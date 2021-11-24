package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteAPIController {
    @GetMapping("/")
    public List<Quote> getRandomQuote(@RequestParam(name = "count", defaultValue = "1")int count){
        System.out.println(count);
        return null;
    }

    @GetMapping("/search")
    public List<Quote> searchKeyword(@RequestParam(name = "query", defaultValue = "")String query,@RequestParam(name = "count", defaultValue = "10")int count){
        System.out.println(query);
        return null;
    }

    @GetMapping("/author/{authorName}")
    public List<Quote> getQuotesFromAuthor(@PathVariable String authorName,@RequestParam(name = "count", defaultValue = "10")int count){
        System.out.println(authorName);
        return null;
    }

    @GetMapping("/tag/{tag}")
    public List<Quote> getQuotesByTag(@PathVariable String tag,@RequestParam(name = "count", defaultValue = "10")int count){
        System.out.println(tag);
        return null;
    }

}
