package com.example.quotesrestapi.contoller;

import com.example.quotesrestapi.model.Quote;
import com.example.quotesrestapi.quoteservice.QuoteService;
import com.example.quotesrestapi.quoteservice.QuoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

//    @Autowired
    private QuoteService quoteService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String hello(){
        System.out.println("Called Hello!");
        return "QuotesAPIServer";
    }

    @GetMapping("/test")
    public HttpStatus test(@RequestParam(name = "id", defaultValue = "10") String id){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS test(name TEXT)");
        jdbcTemplate.execute("INSERT INTO test VALUES ('Stella')");
        List<String> names = jdbcTemplate.query("SELECT * FROM name", (resultSet, rowNum) ->new String(resultSet.getString("name")));
        for(String s : names){
            System.out.println(s);
        }
        return HttpStatus.OK;
    }

    @GetMapping("/test/getquotes")
    public List<Quote> getQuotes(){
        return this.quoteService.getQuotes();
    }

}
