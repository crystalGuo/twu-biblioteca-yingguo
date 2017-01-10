package com.twu.biblioteca;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.menuOperation.BookList;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bookListTest {

    private Printer printer;
    private Inputer inputer;
    private BookList bookList;

    @Before
    public void setUp() {
        List<Book> books = new ArrayList();
        books.add(new Book("Best British and Irish Literature", "Jimes", "2015"));
        books.add(new Book("Best of William Shakespeare", "Lindy", "2013"));
        books.add(new Book("Very British MM", "Gray", "2016"));
        bookList = new BookList(books);
    }

    @Test
    public void testShouldGetBookWhenNameIsCorrect() {
        Optional<Book> book = bookList.getBook("Very British MM");
        assertTrue(book.isPresent());
        assertEquals(book.get().getAuthor(), "Gray");
    }

    @Test
    public void testShouldGetBookWhenNameIsNotCorrect() {
        Optional<Book> book = bookList.getBook("Very British");
        assertFalse(book.isPresent());
    }

    @Test
    public void testCheckoutBook() {
        Optional<Book> book = bookList.getBook("Very British MM");
        bookList.checkOut(book.get());
        book = bookList.getBook("Very British MM");
        assertFalse(book.isPresent());
    }
}
