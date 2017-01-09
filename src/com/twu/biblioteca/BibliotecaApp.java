package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";

    public static void main(String[] args) {
        printWelcomeMessage();
        showBookList();
    }

    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void showBookList() {
        List<String> bookList = new ArrayList<String>();
        bookList.add("The books are listed as: ");
        bookList.add("Best British and Irish Literature");
        bookList.add("Best of William Shakespeare");
        bookList.add("Very British MM");

        Map<String, String> booksMap = new HashMap<String, String>();
        booksMap.put("Best British and Irish Literature\t", addBookInfo("Jimes", "2015"));
        booksMap.put("Best of William Shakespeare\t", addBookInfo("Lindy", "2013"));
        booksMap.put("Very British MM\t", addBookInfo("Gray", "2016"));

        bookList.stream().forEach(book -> System.out.println(book));
        booksMap.entrySet().stream().forEach(book -> {
            System.out.print(book.getKey());
            System.out.print(book.getValue());
        });
    }

    private static String addBookInfo(String author, String publishYear) {
        String bookInfo = author + "\t" + publishYear + "\t\n";

        return bookInfo;
    }
}
