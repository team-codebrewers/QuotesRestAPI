package com.example.quotesrestapi.model;

import com.example.quotesrestapi.exceptions.SuperUserClassException;
import com.example.quotesrestapi.services.DatabaseService;
import com.example.quotesrestapi.services.TokenGenerator;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuperUser extends User{

    public SuperUser(String token) throws SuperUserClassException{
        // creating a user object
        super(token);
        // checking if given token has super user privilege
        if(!this.privilege.equals("super")){
            new SuperUserClassException("You Are Not SuperUser");
        }
    }

    public User registerUser(String email, String privilege) throws Error, SQLException {
        // checking if the user already exists
        String query = "SELECT * FROM users WHERE email='"+email+"'";

        DatabaseService db = new DatabaseService();
        ResultSet rs = db.getQueryResultSet(query);
        db.closeConnection();
        if(rs.next()){
//            throw new Error("User Already Exists");
            return null;
        }
        // generating token
        String token = TokenGenerator.nextToken();
        query = "INSERT INTO users VALUES('"+email + "','" + token + "','" + privilege + "',0)";

        // adding to database

        DatabaseService db2 = new DatabaseService();
        db2.executeUpdateQuery(query);
        db2.closeConnection();
        return new User(token);
    }

    public void updatePrivilege(String email, String privilege){
        DatabaseService db = new DatabaseService();
        String query = "UPDATE users SET privilege=" + privilege + "calls=0 WHERE email='" + email + "'";
        db.executeUpdateQuery(query);
        db.closeConnection();
    }

    public void deleteUser(String email){
        DatabaseService db = new DatabaseService();
        String query = "DELETE FROM users WHERE email='" + email + "'";
        db.executeUpdateQuery(query);
        db.closeConnection();
    }
}
