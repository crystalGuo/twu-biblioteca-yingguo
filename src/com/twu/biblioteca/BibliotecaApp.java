package com.twu.biblioteca;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.libraryComponent.Menu;
import com.twu.biblioteca.menuOperation.BookList;
import com.twu.biblioteca.menuOperation.Operation;
import com.twu.biblioteca.menuOperation.Quit;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

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

        printmenuOption(printer);
    }

    private static void printmenuOption(Printer printer) {
        Map<Integer, Operation> menuItem = new HashMap<>();
        List<Book> bookList = getBookList();
        menuItem.put(1, new BookList(bookList, printer));
        menuItem.put(2, new Quit());
        Menu menu = new Menu(menuItem);

        Inputer inputer = new Inputer();
        while(true) {
            printer.print(menu.toString());
            int option = getOption(inputer);
            if(menu.isValid(option)) {
                menuItem.get(option).operate();
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

    private static int getOption(Inputer inputer) {
        try {
            return Integer.parseInt(inputer.getOption());
        } catch (Exception exception) {
            return -1;
        }
    }
}
