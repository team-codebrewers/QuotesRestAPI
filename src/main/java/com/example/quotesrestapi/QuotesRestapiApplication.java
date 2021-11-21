package com.example.quotesrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@SpringBootApplication
public class QuotesRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuotesRestapiApplication.class, args);
    }

}
