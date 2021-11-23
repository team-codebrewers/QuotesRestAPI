package com.example.quotesrestapi;

import com.example.quotesrestapi.services.SQLconnect;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabseTests {
    @Test
    void checkConnection(){
        SQLconnect sqLconnect = new SQLconnect();
        assertEquals(4, sqLconnect.testDatabaseConnection());
    }

}
