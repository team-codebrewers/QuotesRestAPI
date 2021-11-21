package com.example.quotesrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuotesRestapiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void checkHello(){
        QuotesRestapiApplication home = new QuotesRestapiApplication();
        String result = home.hello();
        assertEquals(result, "Hello World!");
    }

}
