package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

public class CheckOutResource implements Operation{

    private Printer printer;
    private Inputer inputer;
    private Librarian checkoutList;

    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESS_CHECKOUT_MESSAGE = "That book is not available";

    public CheckOutResource(Printer printer, Inputer inputer, Librarian checkoutList) {
        this.printer = printer;
        this.inputer = inputer;
        this.checkoutList = checkoutList;
    }

    @Override
    public void operate() {
        printer.print("Please Input Book's Name:");
        printer.print(checkoutList.getResource().getStockList());
        boolean result = checkoutList.checkoutResource(inputer.getOption());

        if(result) {
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

