package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

import java.util.Optional;

public class CheckOut implements Operation{

    private Printer printer;
    private Inputer inputer;
    private BookList checkoutList;

    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESS_CHECKOUT_MESSAGE = "That book is not available";

    public CheckOut(Printer printer, Inputer inputer, BookList checkoutList) {
        this.printer = printer;
        this.inputer = inputer;
        this.checkoutList = checkoutList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        printer.print(checkoutList.getBookList());
        Optional<Book> checkoutBook = checkoutList.getBorrowableBook(inputer.getOption());

        if(checkoutBook.isPresent()) {
            checkoutList.checkOutBook(checkoutBook.get());
            printer.print(SUCCESS_CHECKOUT_MESSAGE);
        } else {
            printer.print((UNSUCCESS_CHECKOUT_MESSAGE));
        }
    }

    @Override
    public String toString() {
        return "Checkout a book";
    }
}

