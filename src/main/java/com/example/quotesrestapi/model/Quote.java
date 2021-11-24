package com.example.quotesrestapi.model;

import java.util.List;

public class Quote {
    public String quote;
    public String author;
    public List<String> tags;
    public Quote(){}
    public Quote(String quote, String author){
        this.quote = quote;
        this.author = author;
    }

    public Quote(String quote, String author, String tags){
        this.quote = quote;
        this.author = author;
        this.tags = List.of(tags.split("-"));
    }

}

// Quote{quote='TEXT', author='TEXT'}