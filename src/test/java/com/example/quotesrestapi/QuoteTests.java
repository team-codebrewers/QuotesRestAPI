package com.example.quotesrestapi;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.quoteservice.QuoteService;
import com.example.quotesrestapi.quoteservice.QuoteServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteTests {


    @Test
    void testConstructor(){
        Quote testQuote = new Quote("TEXT", "TEXT");
        assertEquals(testQuote.toString(), "Quote{quote='TEXT', author='TEXT'}");
    }

    @Test
    void getQuote(){
        QuoteServiceImpl quoteService = new QuoteServiceImpl();
        assertEquals(quoteService.getQuotes().size(), 3);
    }


}
