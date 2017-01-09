package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    public static final String INVALID_OPTION_MESSAGE = "Select a valid option!";

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);

        Map<Integer, String> menuItem = new HashMap<>();
        menuItem.put(1, "BookList");
        menuItem.put(2, "exit");
        Menu menu = new Menu(menuItem);

        Inputer inputer = new Inputer();
        while(true) {
            printer.print(menu.toString());
            int option = inputer.getOption();
            if(menu.isValid(option)) {
                if(option == 1) {
                    printer.print(getBookList());
                } else if(option == 2) {
                    return;
                }
            } else {
                printer.print(INVALID_OPTION_MESSAGE);
            }
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
