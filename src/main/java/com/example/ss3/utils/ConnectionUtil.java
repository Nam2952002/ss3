package com.example.ss3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static Connection connection;

    public static synchronized  Connection getConnection(){
        String url = "";
        String user = "root";
        String pass = "root";
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
