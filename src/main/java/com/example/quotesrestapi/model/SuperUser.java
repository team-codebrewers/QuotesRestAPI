package com.example.quotesrestapi.model;

import com.example.quotesrestapi.services.TokenGenerator;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuperUser extends User{

    public SuperUser(String token) {
        super(token);
        if(!this.privilege.equals("super")){
            throw new InvalidDataAccessApiUsageException("Invalid Token");
        }
    }

    public User registerUser(String email, String privilege){
        // checking if the user already exists
        String query = "SELECT * FROM users WHERE email='"+email+"'";
        try {
            ResultSet rs = db.getQueryResultSet(query);
            if(rs.next()){
                throw new Error("User Already Exists");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        // generating token
        String token = TokenGenerator.nextToken();
        query = "INSERT INTO users VALUES('"+email + "','" + token + "','" + privilege + "',0)";

        // adding to database
        db.executeUpdateQuery(query);

        return new User(token);
    }

    public void updatePrivilege(String email, String privilege){
        String query = "UPDATE users SET privilege=" + privilege + "calls=0 WHERE email='" + email + "'";
        db.executeUpdateQuery(query);
    }

    public void deleteUser(String email){
        String query = "DELETE FROM users WHERE email='" + email + "'";
        db.executeUpdateQuery(query);
    }
}
