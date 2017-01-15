package com.twu.biblioteca;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.libraryComponent.Resource;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianTest{

    private Printer printer;
    private Inputer inputer;
    private Librarian librarian;

    @Before
    public void setUp() {
        List<Book> books = new ArrayList();
        books.add(new Book("Best British and Irish Literature", "Jimes", "2015"));
        books.add(new Book("Best of William Shakespeare", "Lindy", "2013"));
        books.add(new Book("Very British MM", "Gray", "2016"));
        Resource resource = new Resource(books, "Book");
        librarian = new Librarian(resource);
    }

    @Test
    public void shouldReturnTrueWhenTheBookCanBeCheckout() {
        String bookName = "Very British MM";
        boolean result = librarian.checkoutResource(bookName);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenTheBookCanNotBeCheckout() {
        String bookName = "Very British";
        boolean result = librarian.checkoutResource(bookName);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenTheBookCanBeReturn() {
        String bookName = "Very British MM";
        Book book = new Book("Very British MM", "Gray", "2016");
        librarian.getResource().getCheckoutList().add(book);
        boolean result = librarian.returnResource(bookName);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenTheBookCanNotBeReturn() {
        String bookName = "Very British MM";
        boolean result = librarian.returnResource(bookName);
        assertFalse(result);
    }

}
