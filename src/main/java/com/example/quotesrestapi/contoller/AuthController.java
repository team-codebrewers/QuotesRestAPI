package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthController {

    @PostMapping("/issue")
    public User issueToken(){
        return null;
    }

    @DeleteMapping("/remove")
    public void removeToken(){}

}
