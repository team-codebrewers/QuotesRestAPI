package com.example.quotesrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuotesRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuotesRestapiApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Called Hello!");
        return "Hello World!";
    }
}
