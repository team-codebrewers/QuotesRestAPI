package com.example.quotesrestapi.model;

public class Quote {
    public String quote;
    public String author;
    public Quote(){}
    public Quote(String quote, String author){
        this.quote = quote;
        this.author = author;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }
}

// Quote{quote='TEXT', author='TEXT'}