package com.example.quotesrestapi.quoteservice;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.services.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService{

    List<Quote> quoteList;

    public QuoteServiceImpl(){}

    @Override
    public List<Quote> getQuotes(String query, int count) {
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
