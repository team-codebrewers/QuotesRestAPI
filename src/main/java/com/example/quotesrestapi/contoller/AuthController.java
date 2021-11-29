package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.SuperUser;
import com.example.quotesrestapi.model.User;
import com.example.quotesrestapi.services.TokenGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthController {

    @PostMapping("/issue")
    public User authenticateUser (@RequestHeader (name="x-api-key")String token,@RequestParam(name="email")String email,@RequestParam(name="privilege")String privilege){

            try{
                SuperUser superUser=new SuperUser(token);
                 User user=superUser.registerUser(email,privilege);
                    return user;

                }catch(Exception e){
                    System.out.println("Not a Super User");

                }


    return null;
    }





}
