package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookList {

    private List<Book> bookList;
    private List<Book> checkoutList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
        this.checkoutList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getCheckoutList() {
        return checkoutList;
    }

    public void checkOutBook(Book book) {
        bookList.remove(book);
        checkoutList.add(book);
    }

    public Optional<Book> getBorrowableBook(String name) {
        return bookList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }

    public void returnBook(Book book) {
        checkoutList.remove(book);
        bookList.add(book);
    }

    public Optional<Book> getReturnableBook(String name) {
        return checkoutList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }
}
