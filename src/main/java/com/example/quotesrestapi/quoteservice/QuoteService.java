package com.example.quotesrestapi.quoteservice;

import com.example.quotesrestapi.model.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuoteService {
    List<Quote> getQuotes();
}
