package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.services.DatabaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteAPIController {
    @GetMapping("/")
    public List<Quote> getRandomQuote(@RequestParam(name = "count", defaultValue = "1")int count){
        // TODO: @Aryan write a code to send random quote from database (Or given number of quotes randomly)
        System.out.println(count);
        return null;
    }

    @GetMapping("/search")
    public List<Quote> searchKeyword(@RequestParam(name = "query", defaultValue = "")String keyWord,@RequestParam(name = "count", defaultValue = "10")int count){
        // TODO: @Aryan write code to return quotes containing given keyword
        System.out.println(keyWord);
        return null;
    }

    @GetMapping("/author/{authorName}")
    public List<Quote> getQuotesFromAuthor(@PathVariable String authorName,@RequestParam(name = "count", defaultValue = "10")int count){
        // TODO: @Samruddhi write code to return quotes with given author
        System.out.println(authorName);
        return null;
    }

    @GetMapping("/tag/{tag}")
    public List<Quote> getQuotesByTag(@PathVariable String tag,@RequestParam(name = "count", defaultValue = "10")int count){
        // TODO: @Samruddhi write code to return quotes with given tag
        System.out.println(tag);
        return null;
    }
}
