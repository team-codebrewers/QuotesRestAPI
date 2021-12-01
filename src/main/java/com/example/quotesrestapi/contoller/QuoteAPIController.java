package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.services.DatabaseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/quotes")
public class QuoteAPIController {
    @GetMapping("/")
    public List<Quote> getRandomQuote(@RequestParam(name = "count", defaultValue = "1")int count){

        String query = "SELECT * FROM quotes_dataset ";
        if(count <= 0) count = 1;
        else if(count > 50) count = 50;
        try{
            DatabaseService db = new DatabaseService();
            List<Quote> quoteList = db.getQuoteQuery(query);
            db.closeConnection();
            List<Quote> rev = new ArrayList<>();
            if(quoteList.size() == 0){
                return null;
            }

            if(quoteList.size() < count) {
                count = quoteList.size();
            }

            for(int i = 0; i < count ; i++){
                int randomIndex = new Random().nextInt(quoteList.size());
                rev.add(quoteList.get(randomIndex));
                quoteList.remove(randomIndex);
            }

            return rev;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @GetMapping("/search")
    public List<Quote> searchKeyword(@RequestParam(name = "query", defaultValue = "")String keyWord,@RequestParam(name = "count", defaultValue = "10")int count){

        String query = "SELECT * FROM quotes_dataset WHERE quote LIKE '%"+keyWord+"%' OR author LIKE '%"+keyWord+"%' OR tags LIKE '%"+keyWord+"%'";
        if(count <= 0) count = 1;
        else if(count > 50) count = 50;
        try{
            DatabaseService db = new DatabaseService();
            List<Quote> quoteList = db.getQuoteQuery(query);
            db.closeConnection();
            List<Quote> rev = new ArrayList<>();
            if(quoteList.size() == 0){
                return null;
            }

            if(quoteList.size() < count) {
                count = quoteList.size();
            }

            for(int i = 0; i < count ; i++){
                int randomIndex = new Random().nextInt(quoteList.size());
                rev.add(quoteList.get(randomIndex));
                quoteList.remove(randomIndex);
            }

            return rev;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/author/{authorName}")
    public List<Quote> getQuotesFromAuthor(@PathVariable String authorName,@RequestParam(name = "count", defaultValue = "10")int count){

        String query = "SELECT * FROM quotes_dataset WHERE author LIKE '%"+ authorName+"%'";
        if(count <= 0) count = 1;
        else if(count > 50) count = 50;
        try{
            DatabaseService db = new DatabaseService();
            List<Quote> quoteList = db.getQuoteQuery(query);
            db.closeConnection();
            List<Quote> rev = new ArrayList<>();
            if(quoteList.size() == 0){
                return null;
            }

            if(quoteList.size() < count) {
                count = quoteList.size();
            }

            for(int i = 0; i < count ; i++){
                int randomIndex = new Random().nextInt(quoteList.size());
                rev.add(quoteList.get(randomIndex));
                quoteList.remove(randomIndex);
            }

            return rev;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/tag/{tag}")
    public List<Quote> getQuotesByTag(@PathVariable String tag,@RequestParam(name = "count", defaultValue = "10")int count){

        String query = "SELECT * FROM quotes_dataset WHERE tag LIKE '%"+ tag+"%'";
        if(count <= 0) count = 1;
        else if(count > 50) count = 50;
        try{
            DatabaseService db = new DatabaseService();
            List<Quote> quoteList = db.getQuoteQuery(query);
            db.closeConnection();
            List<Quote> rev = new ArrayList<>();
            if(quoteList.size() == 0){
                return null;
            }

            if(quoteList.size() < count) {
                count = quoteList.size();
            }

            for(int i = 0; i < count ; i++){
                int randomIndex = new Random().nextInt(quoteList.size());
                rev.add(quoteList.get(randomIndex));
                quoteList.remove(randomIndex);
            }

            return rev;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
