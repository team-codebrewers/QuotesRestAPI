package com.example.quotesrestapi;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.services.DatabaseService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTests {
    @Test
    void checkConnection(){
        DatabaseService db = new DatabaseService();
        assertEquals(true, db.isConnected());
        db.closeConnection();

    }

    @Test
    void queryCheck(){
        DatabaseService db = new DatabaseService();
        List<Quote> quoteList = db.getQuoteQuery("SELECT * FROM quotes_dataset WHERE author='Marilyn Monroe'");
        db.closeConnection();
        assertEquals(78, quoteList.size());
    }
}
