package com.example.csit228_f1_v2.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUser extends DatabaseManager{
    private String username;
    private String password;
    public CreateUser(String username, String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean run() {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("INSERT INTO tblusers(username, password) VALUES(?, ?)")){

            statement.setString(1, username);
            statement.setString(2, password);

            int res = statement.executeUpdate();
            System.out.println("Rows created: " + res);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
