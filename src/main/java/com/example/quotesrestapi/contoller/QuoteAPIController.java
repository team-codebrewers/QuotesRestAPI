package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.model.ResponseTransfer;
import com.example.quotesrestapi.quoteservice.QuoteService;
import com.example.quotesrestapi.quoteservice.QuoteServiceImpl;
import com.example.quotesrestapi.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/quotes")
public class QuoteAPIController {

    @Autowired
    private QuoteService quoteService = new QuoteServiceImpl();

    @GetMapping("/")
    public ResponseTransfer<List<Quote>> getRandomQuote(@RequestParam(name = "count", defaultValue = "1")int count){
        String query = "SELECT * FROM quotes_dataset ";
        List<Quote> quoteList = quoteService.getQuotes(query, count);
        if (quoteList == null){
            return new ResponseTransfer("failed", quoteList, "Queried data not found");
        }
        return new ResponseTransfer("sucess", quoteList);
    }

    @GetMapping("/search")
    public ResponseTransfer<List<Quote>> searchKeyword(@RequestParam(name = "query", defaultValue = "")String keyWord,@RequestParam(name = "count", defaultValue = "10")int count){
        String query = "SELECT * FROM quotes_dataset WHERE quote LIKE '%"+keyWord+"%' OR author LIKE '%"+keyWord+"%' OR tags LIKE '%"+keyWord+"%'";
        List<Quote> quoteList = quoteService.getQuotes(query, count);
        if (quoteList == null){
            return new ResponseTransfer("failed", quoteList, "Queried data not found");
        }
        return new ResponseTransfer("sucess", quoteList);
    }

    @GetMapping("/author/{authorName}")
    public ResponseTransfer<List<Quote>> getQuotesFromAuthor(@PathVariable String authorName,@RequestParam(name = "count", defaultValue = "10")int count){
        List<String> authorNameList = List.of(authorName.split("-"));
        authorName = String.join(" ", authorNameList);
        System.out.println(authorName);
        String query = "SELECT * FROM quotes_dataset WHERE author LIKE '%"+ authorName+"%'";
        List<Quote> quoteList = quoteService.getQuotes(query, count);
        if (quoteList == null){
            return new ResponseTransfer("failed", quoteList, "Queried data not found");
        }
        return new ResponseTransfer("sucess", quoteList);
    }

    @GetMapping("/tag/{tag}")
    public ResponseTransfer<List<Quote>> getQuotesByTag(@PathVariable String tag,@RequestParam(name = "count", defaultValue = "10")int count){
        String query = "SELECT * FROM quotes_dataset WHERE tags LIKE '%"+ tag+"%'";
        List<Quote> quoteList = quoteService.getQuotes(query, count);
        if (quoteList == null){
            return new ResponseTransfer("failed", quoteList, "Queried data not found");
        }
        return new ResponseTransfer("sucess", quoteList);
    }
}
