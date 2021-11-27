package com.example.quotesrestapi.model;

import java.util.List;

public class Quote {
    //fields
    public String quote;
    public String author;
    public List<String> tags;

    public Quote() {
    }

    // parameterised constructors
    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public Quote(String quote, String author, String tags) {
        this.quote = quote;
        this.author = author;
        this.tags = List.of(tags.split("-"));
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }
}