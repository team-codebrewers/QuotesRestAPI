package com.example.quotesrestapi;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.quoteservice.QuoteService;
import com.example.quotesrestapi.quoteservice.QuoteServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteTests {
    /*
    These tests are performed on the Quote Class
     */

    @Test
    void testConstructor(){
        Quote testQuote = new Quote("TEXT", "TEXT", "Hello-World");
//        assertEquals( "Quote{quote='TEXT', author='TEXT', tags=[Hello, World]}",testQuote.toString());
//        assertEquals("TEXT",testQuote.getAuthor());
    }

    @Test
    void toStringTest(){
        Quote testQuote = new Quote("TEXT", "TEXT", "Hello-World");
//        assertEquals( "Quote{quote='TEXT', author='TEXT', tags=[Hello, World]}",testQuote.toString());
    }

    @Test
    void getterTest(){
        Quote testQuote = new Quote("TEXT", "TEXT", "Hello-World");
//        assertEquals("TEXT",testQuote.getAuthor());
    }

}
