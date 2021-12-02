package com.example.quotesrestapi;

import com.example.quotesrestapi.contoller.QuoteAPIController;
import com.example.quotesrestapi.model.Quote;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteAPIFunctionTest {
    @Test
    void testRandomQuote(){
        List<Quote> quoteList = new QuoteAPIController().getRandomQuote(100);
        quoteList.forEach((q) -> System.out.println(q.toString()));
        assertEquals(50, quoteList.size());
    }

    @Test
    void testSearchKeyWord(){
        List<Quote> quoteList = new QuoteAPIController().searchKeyword("love", 10);
        quoteList.forEach((q) -> System.out.println(q.toString()));
        assertEquals(10, quoteList.size());
    }

    @Test
    void testAuthorQuote(){
        List<Quote> quoteList = new QuoteAPIController().getQuotesFromAuthor("Steve-jobs", 10);
        quoteList.forEach((q) -> System.out.println(q.toString()));
        assertEquals(10, quoteList.size());
    }

    @Test
    void testTagQuote(){
        List<Quote> quoteList = new QuoteAPIController().getQuotesByTag("happiness", 10);
        quoteList.forEach((q) -> System.out.println(q.toString()));
        assertEquals(10, quoteList.size());
    }
}
