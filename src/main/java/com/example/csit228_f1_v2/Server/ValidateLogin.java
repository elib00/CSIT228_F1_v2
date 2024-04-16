package com.example.csit228_f1_v2.Server;

import java.sql.*;

public class ValidateLogin {
    private String username;
    private String password;

    public ValidateLogin(String username, String password){
        this.password = password;
        this.username = username;
    }

    public AuthStatus run() {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("SELECT * FROM tblusers WHERE username = ? ")){
            System.out.println("nisulod");

            statement.setString(1, username);
            ResultSet res = statement.executeQuery();

            if(!res.next()) return AuthStatus.USERNAME_NOT_FOUND;

            System.out.println("naay sulod ang query");
            String passwordFromDB = res.getString("password");
            System.out.println(passwordFromDB);
            System.out.println(password);
            if(passwordFromDB.equals(password)){
                System.out.println("Login successfully. Welcome, " + username);
                return AuthStatus.LOGIN_SUCCESS;
            }

            assert res != null;

            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("username");
                String email = res.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Username: " + name);
                System.out.println("Email: " + email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return AuthStatus.INCORRECT_PASSWORD;
    }

}


