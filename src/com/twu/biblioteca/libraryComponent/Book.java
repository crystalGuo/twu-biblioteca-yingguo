package com.twu.biblioteca.libraryComponent;

public class Book {

    private String name;
    private String author;
    private String publishYear;

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", name, author, publishYear);
    }
}
