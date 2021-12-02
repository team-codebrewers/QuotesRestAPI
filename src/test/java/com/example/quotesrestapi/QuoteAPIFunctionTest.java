package com.example.quotesrestapi;

import com.example.quotesrestapi.contoller.QuoteAPIController;
import com.example.quotesrestapi.model.Quote;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuoteAPIFunctionTest {

    @Test
    void hello(){
        assertEquals(4, 2+2);
    }
    @Test
    void code_tester() {
        QuoteAPIController obj=new QuoteAPIController();
        List<Quote> my_quote_list=obj.getRandomQuote(2);
        System.out.println(my_quote_list.get(0).toString());
    }
    @Test
    void code_tester_2(){
       QuoteAPIController obj=new QuoteAPIController();
       List<Quote> quote_list=obj.searchKeyword("happiness", 20);
        System.out.println(quote_list.get(0).toString());
    }

}
