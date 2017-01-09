package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);

        Map<Integer, String> menuItem = new HashMap<>();
        menuItem.put(1, "BookList");
        Menu menu = new Menu(menuItem);
        printer.print(menu.toString());

        Inputer inputer = new Inputer();
        if(inputer.getOption() == 1) {
            List<Book> bookList = getBookList();
            printer.print(bookList);
        }
    }

    private static List getBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Best British and Irish Literature", "Jimes", "2015"));
        bookList.add(new Book("Best of William Shakespeare", "Lindy", "2013"));
        bookList.add(new Book("Very British MM", "Gray", "2016"));

        return bookList;
    }
}
