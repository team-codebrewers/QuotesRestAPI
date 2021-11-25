package com.example.quotesrestapi;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.services.DatabaseService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTests {
    static DatabaseService db = new DatabaseService();
    @Test
    void checkConnection(){
        assertEquals(true, db.isConnected());
    }

    @Test
    void queryCheck(){
        List<Quote> quoteList = db.getQuoteQuery("SELECT * FROM quotes_dataset WHERE author='Marilyn Monroe'");
        assertEquals(78, quoteList.size());
    }
}
