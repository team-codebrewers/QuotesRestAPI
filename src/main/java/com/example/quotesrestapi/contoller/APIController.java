package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.quoteservice.QuoteService;
import com.example.quotesrestapi.quoteservice.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/")
    public String hello(){
        System.out.println("Called Hello!");
        return "QuotesAPIServer";
    }

    @GetMapping("/test")
    public HttpStatus test(@RequestParam(name = "id", defaultValue = "10") String id){
        System.out.println("The ID is : "+ id);
        return HttpStatus.OK;
    }

    @GetMapping("/test/getquotes")
    public List<Quote> getQuotes(){
        return this.quoteService.getQuotes();
    }

}
