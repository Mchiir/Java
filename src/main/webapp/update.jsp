<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.InputStream, java.util.*, java.sql.*" %>

<%
    Properties props = new Properties();
    try (InputStream input = application.getResourceAsStream("/WEB-INF/classes/db.properties")) {
        if (input == null) {
            throw new Exception("Database configuration file not found!");
        }
        props.load(input);
    }

    String dbUrl = props.getProperty("db.url");
    String dbUser = props.getProperty("db.user");
    String dbPassword = props.getProperty("db.password");

    if (request.getParameter("submit") != null) {
        String id = request.getParameter("id");
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pst = con.prepareStatement("UPDATE records SET sname=?, course=?, fee=? WHERE id=?")) {
            pst.setString(1, name);
            pst.setString(2, course);
            pst.setString(3, fee);
            pst.setString(4, id);
            pst.executeUpdate();
%>
<script>alert("Record updated successfully!"); window.location.href='index.jsp';</script>
<%
} catch (SQLException e) {
%>
<script>alert("Error updating record: <%= e.getMessage() %>");</script>
<%
        }
    }
%>

<html>
<head>
    <title>Update Student</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Update Student</h1>

<div class="row">
    <div class="col-sm-4">
        <form method="post" action="update.jsp">
            <%
                String id = request.getParameter("id");
                try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     PreparedStatement pst = con.prepareStatement("SELECT * FROM records WHERE id=?")) {

                    pst.setString(1, id);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
            %>

            <input type="hidden" name="id" value="<%= id %>">

            <div align="left">
                <label class="form-label">Student Name</label>
                <input type="text" class="form-control" value="<%= rs.getString("sname") %>" name="sname" required>
            </div>

            <div align="left">
                <label class="form-label">Course</label>
                <input type="text" class="form-control" value="<%= rs.getString("course") %>" name="course" required>
            </div>

            <div align="left">
                <label class="form-label">Fee</label>
                <input type="text" class="form-control" value="<%= rs.getString("fee") %>" name="fee" required>
            </div>

            <%
                        }
                    }
                }
            %>

            <br>
            <div align="right">
                <input type="submit" value="Update" name="submit" class="btn btn-info">
                <input type="reset" value="Reset" class="btn btn-warning">
            </div>

            <div align="right">
                <p><a href="index.jsp">Back</a></p>
            </div>
        </form>
    </div>
</div>
</body>
</html>