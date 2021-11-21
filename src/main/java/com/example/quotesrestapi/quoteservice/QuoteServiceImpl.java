package com.example.quotesrestapi.quoteservice;

import com.example.quotesrestapi.model.Quote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{

    List<Quote> quoteList;

    public QuoteServiceImpl(){
        this.quoteList = new ArrayList<>();
        quoteList.add(new Quote("TEST01", "AUTH01"));
        quoteList.add(new Quote("TEST02", "AUTHOR02"));
        quoteList.add(new Quote("TEST03", "AUTHOR03"));
    }


    @Override
    public List<Quote> getQuotes() {
        return quoteList;
    }
}
