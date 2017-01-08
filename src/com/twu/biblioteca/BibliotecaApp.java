package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

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
        bookList.stream().forEach(book -> System.out.println(book));
    }
}
