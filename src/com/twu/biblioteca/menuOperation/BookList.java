package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Book;

import java.util.List;
import java.util.Optional;

public class BookList {

    private List<Book> bookList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void checkOut(Book book) {
        bookList.remove(book);
    }

    public Optional<Book> getBook(String name) {
        return bookList.stream().filter(book -> name.equals(book.getName())).findFirst();
    }
}
