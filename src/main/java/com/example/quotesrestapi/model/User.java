package com.example.quotesrestapi.model;

import com.example.quotesrestapi.services.DatabaseService;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public static String free = "free";
    public static String paid = "paid";
    DatabaseService db = new DatabaseService();
    String email;
    String token;
    String privilege;
    int calls;

    public User(String email, String token, String privilege, int calls) {
        this.email = email;
        this.token = token;
        this.privilege = privilege;
        this.calls = calls;
    }

    public User(String token){
        DatabaseService db = new DatabaseService();
        String query = "SELECT * FROM users WHERE token='" + token + "'";

        // trying to retrieve data
        try {
            ResultSet rs = db.getQueryResultSet(query);
            if(rs.next()){
                this.email = rs.getString("email");
                this.token = rs.getString("token");
                this.privilege = rs.getString("privilege");
                this.calls = rs.getInt("calls");

            }
            db.closeConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }


        // if we got null values of data then we will throw exception
        if(this.email == null){
            throw new InvalidDataAccessApiUsageException("Invalid Token");
        }
    }

    // to check if he as access to API data or not
    public boolean isCallValid(){
        if(this.privilege.equals("super")){
            return true;
        }else if(this.privilege.equals("paid")){
            return true;
        }else if(this.privilege.equals("free")){
            if(this.calls < 100){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    // updating call count
    public void updateCalls(){
        if(this.isCallValid()){
            DatabaseService db = new DatabaseService();
            String query = "UPDATE users SET calls=" + String.valueOf(this.calls + 1) + " WHERE email='" + this.email + "'";
            try {
                db.executeUpdateQuery(query);
                this.calls++;
            } catch (Exception e) {
                e.printStackTrace();
            }

            db.closeConnection();
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "db=" + db +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", privilege='" + privilege + '\'' +
                ", calls=" + calls +
                '}';
    }
}
