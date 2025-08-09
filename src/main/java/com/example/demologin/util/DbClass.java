package com.example.demologin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbClass {
    // Railway PostgreSQL bağlantı məlumatları
    static final String CONNECTION_URL = "jdbc:postgresql://yamabiko.proxy.rlwy.net:38131/railway";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "pbJUzMFikJRPNDaZVyoHTBrIoaIKNzgh";

    public static Connection CONNECTION;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            CONNECTION = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            System.out.println("✅ Connection successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL Driver not found!");
        } catch (SQLException e) {
            System.out.println("CONNECTION ERROR! " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (CONNECTION != null && !CONNECTION.isClosed()) {
                CONNECTION.close();
                System.out.println("❌ Connection disconnected!");
            }
        } catch (SQLException e) {
            System.out.println("DISCONNECTION ERROR: " + e.getMessage());
        }
    }
}
