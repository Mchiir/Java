<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    String message = "Database connected successfully!";

    try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         Statement stmt = con.createStatement()) {

        Class.forName(props.getProperty("db.driver"));

        // Create table if it doesn't exist
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS records (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    sname VARCHAR(30),
                    course VARCHAR(30),
                    fee VARCHAR(10)
                )""";
        stmt.executeUpdate(createTableSQL);

    } catch (Exception e) {
        message = "Database connection failed: " + e.getMessage();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome - JSP App</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-primary">Welcome to the Student Registration System</h2>
    <p class="lead"><%= message %></p>
    <a href="index.jsp" class="btn btn-success">Go to Main App</a>
</div>
</body>
</html>