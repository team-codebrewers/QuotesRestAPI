package com.example.quotesrestapi.services;

import com.example.quotesrestapi.model.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    String baseLocation = "src/main/resources/quotes.sqlite";
    public Connection connection = null;
    private boolean connected = false;
    public DatabaseService(){
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseLocation);
            System.out.println("CONNECTED To "+ this.baseLocation);
            this.connected = true;
        } catch (SQLException e) {
            this.connected = false;
            e.printStackTrace();
        }
    }

    public boolean isConnected(){
        return this.connected;
    }


    public List<Quote> getQueryResponse(String query){
        if(this.connected == false){
            return null;
        }
        try{
            List<Quote> rev = new ArrayList<>();
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                rev.add(new Quote(rs.getString("quote"), rs.getString("author")));
            }
            return rev;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
