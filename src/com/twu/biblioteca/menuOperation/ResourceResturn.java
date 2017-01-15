package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;


public class ResourceResturn implements Operation{

    private Printer printer;
    private Inputer inputer;
    private Librarian librarian;

    public static final String SUCCESS_RETURN_BOOK_MESSAGE = "Thank you for returning the %s.";
    public static final String UNSUCCESS_RETURN_BOOK_MESSAGE = "That is not a valid %s to return.";

    public ResourceResturn(Printer printer, Inputer inputer, Librarian librarian) {
        this.printer = printer;
        this.inputer = inputer;
        this.librarian = librarian;
    }

    @Override
    public void operate() {
        String successMsg = String.format(SUCCESS_RETURN_BOOK_MESSAGE, getElementName());
        String unsuccessMsg = String.format(UNSUCCESS_RETURN_BOOK_MESSAGE, getElementName());
        printer.print("Please Input It's Name You Want To Return:");
        boolean result = librarian.returnResource(inputer.getOption());

        if(result) {
            printer.print(successMsg);
        } else {
            printer.print(unsuccessMsg);
        }
    }

    private String getElementName() {
        return librarian.getResource().getName();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Return", getElementName());

    }
}
