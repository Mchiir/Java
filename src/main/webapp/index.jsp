<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.io.InputStream" %>
<%@page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%
    Properties props = new Properties();
    InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");

    if (input != null) {
        props.load(input);
    } else {
%>
<script>alert("Error: Database configuration file not found!");</script>
<%
    }

    String dbUrl = props.getProperty("db.url");
    String dbUser = props.getProperty("db.user");
    String dbPassword = props.getProperty("db.password");

    try {
        // 🔹 Load MySQL JDBC Driver
        Class.forName(props.getProperty("db.driver"));
    } catch (ClassNotFoundException e) {
%>
<script>alert("Error: MySQL JDBC Driver not found!");</script>
<%
    }

    if (request.getParameter("submit") != null) {
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pst = con.prepareStatement("INSERT INTO records(sname, course, fee) VALUES (?,?,?)")) {
            pst.setString(1, name);
            pst.setString(2, course);
            pst.setString(3, fee);
            pst.executeUpdate();
%>
<script>alert("Record added successfully");</script>
<%
} catch (SQLException e) {
%>
<script>alert("Database Error: <%= e.getMessage() %>");</script>
<%
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1><%= "Student Registration System with JSP" %></h1>
<br>

<div class="row">
    <!-- Input form -->
    <div class="col-sm-4">
        <form method="post" action="#">
            <div align="left">
                <label class="form-label">Student Name</label>
                <input type="text" class="form-control" placeholder="Student Name" name="sname" id="sname" required>
            </div>

            <div align="left">
                <label class="form-label">Course</label>
                <input type="text" class="form-control" placeholder="Course" name="course" id="course" required>
            </div>

            <div align="left">
                <label class="form-label">Fee</label>
                <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" required>
            </div>

            <br>

            <div align="right">
                <input type="submit" id="submit" value="Submit" name="submit" class="btn btn-info">
                <input type="reset" id="reset" value="Reset" name="reset" class="btn btn-warning">
            </div>

        </form>
    </div>

    <!-- Results table -->
    <div class="col-sm-8">
        <table id="tbl-student" class="table table-responsive table-bordered" cellpadding="0" width="100%">
            <thead>
            <tr>
                <th>Student Name</th>
                <th>Course</th>
                <th>Fee</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <%
                try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery("SELECT * FROM records")) {
                    while (rs.next()) {
                        String id = rs.getString("id");
            %>
            <tr>
                <td><%= rs.getString("sname") %></td>
                <td><%= rs.getString("course") %></td>
                <td><%= rs.getString("fee") %></td>
                <td><a href="update.jsp?id=<%= id %>">Edit</a></td>
                <td><a href="delete.jsp?id=<%= id %>">Delete</a></td>
            </tr>
            <%
                }
            } catch (SQLException e) {
            %>
            <tr><td colspan="5">Database Error: <%= e.getMessage() %></td></tr>
            <%
                }
            %>
            </thead>
        </table>
    </div>
</div>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>