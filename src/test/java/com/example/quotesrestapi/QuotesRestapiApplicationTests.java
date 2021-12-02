package com.example.quotesrestapi;

import com.example.quotesrestapi.contoller.APIController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuotesRestapiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void checkHello(){
        APIController apiController = new APIController();
        String result = apiController.hello();
        assertEquals(result, "QuotesAPIServer");
    }

    @Test
    void checkTest(){
        APIController apiController = new APIController();
//        assertEquals(apiController.test("300"),HttpStatus.OK);
    }

}
