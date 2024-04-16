package com.example.csit228_f1_v2.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/dbnapinas";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    static Connection getConnection() {
        Connection c = null;
        try{
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connection successfully established.");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        try{
            connection.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
