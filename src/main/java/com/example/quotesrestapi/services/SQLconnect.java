package com.example.quotesrestapi.services;

import java.sql.*;

public class SQLconnect {
    String baseLocation = "src/main/resources/quotes.sqlite";
    public Connection connection = null;
    public boolean connected = false;
    public SQLconnect(){
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseLocation);
            System.out.println("CONNECTED To "+ this.baseLocation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int testDatabaseConnection(){
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM test");
            int size = 0;
            while (rs.next()){
                size++;
            }
            return size;

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}
