package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Book;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

import java.util.Optional;

public class BookReturn implements Operation{

    private Printer printer;
    private Inputer inputer;
    private BookList bookList;

    public BookReturn(Printer printer, Inputer inputer, BookList bookList) {
        this.printer = printer;
        this.inputer = inputer;
        this.bookList = bookList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name You Want To Return:");
        Optional<Book> returnBook = bookList.getReturnableBook(inputer.getOption());

        if(returnBook.isPresent()) {
            bookList.returnBook(returnBook.get());
        }
    }

    @Override
    public String toString() {
        return "Return a Book";
    }
}
