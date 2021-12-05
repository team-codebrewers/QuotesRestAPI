package com.example.quotesrestapi;

import com.example.quotesrestapi.contoller.AuthController;
import com.example.quotesrestapi.model.SuperUser;
import com.example.quotesrestapi.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserClassTest {
    @Test
    void basicTest(){
        User user = new User("paid123");
        assertEquals(true, user.isCallValid());
    }

    @Test
    void constructorTest(){
        User user = new User("abhinav","ae1234",User.free, 10);
        System.out.println(user.toString());
    }

    @Test
    void registrationTest(){
        AuthController authController = new AuthController();
//        System.out.println(authController.authenticateUser("super123", "abhinavemail110", "paid").toString());
    }
}
