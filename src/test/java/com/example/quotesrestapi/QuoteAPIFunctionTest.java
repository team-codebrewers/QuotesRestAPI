package com.example.quotesrestapi;

import com.example.quotesrestapi.contoller.QuoteAPIController;
import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.model.ResponseTransfer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteAPIFunctionTest {
    @Test
    void testRandomQuote(){
        ResponseTransfer<List<Quote>> quoteList = new QuoteAPIController().getRandomQuote(100);
        System.out.println(quoteList.toString());
        assertEquals(50, quoteList.data.size());
    }

    @Test
    void testSearchKeyWord(){
        ResponseTransfer<List<Quote>> quoteList = new QuoteAPIController().searchKeyword("love", 10);
        System.out.println(quoteList.toString());
        assertEquals(10, quoteList.data.size());
    }

    @Test
    void testAuthorQuote(){
        ResponseTransfer<List<Quote>> quoteList = new QuoteAPIController().getQuotesFromAuthor("Steve-jobs", 10);
        System.out.println(quoteList.toString());
        assertEquals(10, quoteList.data.size());
    }

    @Test
    void testTagQuote(){
        ResponseTransfer<List<Quote>> quoteList = new QuoteAPIController().getQuotesByTag("happiness", 10);
        System.out.println(quoteList.toString());
        assertEquals(10, quoteList.data.size());
    }
}
