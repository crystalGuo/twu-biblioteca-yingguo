package com.twu.biblioteca;


import com.twu.biblioteca.menuOperation.BookList;
import com.twu.biblioteca.menuOperation.Operation;
import com.twu.biblioteca.menuOperation.Quit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PrinterTest {

    private static final String WELCOME_MESSAGE = "Welcome to Bibliteca!";
    private ByteArrayOutputStream output;
    private Printer printer;
    private static List<Book> bookList = new ArrayList<>();

    @Before
    public void setUpStreams() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printer = new Printer();
    }

    @Test
    public void testWelcomMessage() {
        String expectResult = "Welcome to Bibliteca!\n";
        printer.print(WELCOME_MESSAGE);
        assertThat(output.toString(), is(expectResult));
    }

    @Test
    public void testBookPrinter() {

        bookList.add(new Book("Best British and Irish Literature", "Jimes", "2015"));
        bookList.add(new Book("Best of William Shakespeare", "Lindy", "2013"));
        bookList.add(new Book("Very British MM", "Gray", "2016"));


        String expectResult =
                "Best British and Irish Literature\t" +
                "Jimes\t2015\n" +
                "Best of William Shakespeare\t" +
                "Lindy\t2013\n" +
                "Very British MM\t" +
                "Gray\t2016\n";

        printer.print(bookList);

        assertThat(output.toString(), is(expectResult));
    }

    @Test
    public void testMenunPrinter() {
        Map<Integer, Operation> menuItem = new HashMap<>();
        menuItem.put(1, new BookList(bookList, printer));
        menuItem.put(2, new Quit());
        Menu menu = new Menu(menuItem);

        String expectResult = "1\tBookList\n2\tQuit\n";;
        printer.print(menu.toString());
        assertThat(output.toString(), is(expectResult));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
