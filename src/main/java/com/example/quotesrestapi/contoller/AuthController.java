package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.model.ResponseTransfer;
import com.example.quotesrestapi.model.SuperUser;
import com.example.quotesrestapi.model.User;
import com.example.quotesrestapi.services.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class AuthController {

    @PostMapping("/issue")
    public ResponseTransfer<User> authenticateUser (@RequestHeader (name="x-api-key")String token,@RequestParam(name="email")String email,@RequestParam(name="privilege")String privilege){

            try{
                SuperUser superUser=new SuperUser(token);
                User user=superUser.registerUser(email,privilege);
                if(user != null){
                    return new ResponseTransfer("sucess", user, "Thanks");
                }

                }catch(Exception e){
                    System.out.println("Not a Super User");
//                    return new ResponseTransfer("failed", null, "Please use super user token");
                }


    return new ResponseTransfer("failed", null, "USER privilage may be invalid or email already registered");
    }

}
