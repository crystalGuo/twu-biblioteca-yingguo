package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private String publishYear;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", name, author, publishYear);
    }
}
