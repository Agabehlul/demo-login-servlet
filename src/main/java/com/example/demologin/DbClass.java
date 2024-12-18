package com.example.demologin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbClass {
    static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/java162";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "12345";
    public static Connection CONNECTION;

    public void connect() throws SQLException {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            CONNECTION = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            System.out.println("Connection successfully!");

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR!  " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (CONNECTION != null && !CONNECTION.isClosed()) {
                CONNECTION.close();
                System.out.println("Connection disconnected!");
            }
        } catch (SQLException e) {
            System.out.println("DISCONNECTION ERROR: " + e.getMessage());
        }
    }

}


