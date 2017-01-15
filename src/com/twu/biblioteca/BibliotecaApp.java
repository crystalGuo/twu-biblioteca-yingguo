package com.twu.biblioteca;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.libraryComponent.Menu;
import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.libraryComponent.Resource;
import com.twu.biblioteca.menuOperation.ResourceResturn;
import com.twu.biblioteca.menuOperation.Catalog;
import com.twu.biblioteca.menuOperation.CheckOutResource;
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
        List<Book> list = getBookList();
        Resource books = new Resource(list, "Book");
        Librarian bookList = new Librarian(books);
        Inputer inputer = new Inputer();
        menuItem.put(1, new Catalog(bookList, printer));
        menuItem.put(2, new CheckOutResource(printer, inputer, bookList));
        menuItem.put(3, new ResourceResturn(printer, inputer, bookList));
        menuItem.put(4, new Quit());
        Menu menu = new Menu(menuItem);

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
