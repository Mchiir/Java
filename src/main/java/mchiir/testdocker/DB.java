package mchiir.testdocker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3030/db01";
        String user = "guest";
        String password = "guest";

        try(Connection conn = DriverManager.getConnection(url, user, password)){
            if (conn != null){
                System.out.println("Connected to database");
            }
        } catch (SQLException e) {
            System.out.println("error: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
