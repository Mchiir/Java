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

        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
                try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                     PreparedStatement pst = con.prepareStatement("DELETE FROM records WHERE id=?")) {

                        pst.setString(1, id);
                        pst.executeUpdate();
%>
<script>alert("Record Deleted Successfully!"); window.location.href='index.jsp';</script>
<%
} catch (SQLException e) {
%>
<script>alert("Error deleting record: <%= e.getMessage() %>");</script>
<%
        }
} else {
%>
<script>alert("Invalid Record ID!"); window.location.href='index.jsp';</script>
<%
        }
%>