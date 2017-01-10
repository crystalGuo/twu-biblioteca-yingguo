package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

import java.util.Optional;

public class CheckOut implements Operation{

    private Printer printer;
    private Inputer inputer;
    private BookList bookList;

    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";

    public CheckOut(Printer printer, Inputer inputer, BookList bookList) {
        this.printer = printer;
        this.inputer = inputer;
        this.bookList = bookList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        printer.print(bookList.getBookList());
        Optional<Book> checkoutBook = bookList.getBook(inputer.getOption());

        if(checkoutBook.isPresent()) {
            bookList.checkOut(checkoutBook.get());
            printer.print(SUCCESS_CHECKOUT_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}

