package com.example.quotesrestapi.services;

import com.example.quotesrestapi.model.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    // database address
    String baseLocation = "src/main/resources/quotes.sqlite";
    public Connection connection = null;
    private boolean connected = false;

    public DatabaseService(){
        try {
            // trying to connect to database
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


    public List<Quote> getQuoteQuery(String query){
        if(!this.connected){ // if not connected to DB then returns
            return null;
        }
        try{
            List<Quote> rev = new ArrayList<>();
            Statement stmt = this.connection.createStatement(); // creating statement
            ResultSet rs = stmt.executeQuery(query); // querying
            while (rs.next()){
                // adding results to an array
                rev.add(new Quote(rs.getString("quote"), rs.getString("author"),rs.getString("tags")));
            }
            return rev;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getQueryResultSet(String query){
        if(!this.connected){ // if not connected to DB then returns
            return null;
        }
        try{
            Statement stmt = this.connection.createStatement(); // creating statement
            return stmt.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdateQuery(String query){
        if(!this.connected){ // if not connected to DB then returns
            return;
        }
        try{
            Statement stmt = this.connection.createStatement(); // creating statement
            stmt.executeUpdate(query); // querying

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        if(this.connected){
            try {
                this.connection.close();
                System.out.println("Connection to " + this.baseLocation + " is closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
