package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;


public class ResourceResturn implements Operation{

    private Printer printer;
    private Inputer inputer;
    private Librarian librarian;

    public static final String SUCCESS_RETURN_BOOK_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESS_RETURN_BOOK_MESSAGE = "That is not a valid book to return.";

    public ResourceResturn(Printer printer, Inputer inputer, Librarian librarian) {
        this.printer = printer;
        this.inputer = inputer;
        this.librarian = librarian;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name You Want To Return:");
        boolean result = librarian.returnResource(inputer.getOption());

        if(result) {
            printer.print(SUCCESS_RETURN_BOOK_MESSAGE);
        } else {
            printer.print(UNSUCCESS_RETURN_BOOK_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Return a Book";
    }
}
