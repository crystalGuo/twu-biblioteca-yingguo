package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.util.Inputer;
import com.twu.biblioteca.util.Printer;

public class CheckOutResource implements Operation{

    private Printer printer;
    private Inputer inputer;
    private Librarian checkoutList;

    public static final String SUCCESS_CHECKOUT_MESSAGE = "Thank you! Enjoy the %s";
    public static final String UNSUCCESS_CHECKOUT_MESSAGE = "That %s is not available";

    public CheckOutResource(Printer printer, Inputer inputer, Librarian checkoutList) {
        this.printer = printer;
        this.inputer = inputer;
        this.checkoutList = checkoutList;
    }

    @Override
    public void operate() {
        String successMsg = String.format(SUCCESS_CHECKOUT_MESSAGE, getElementName());
        String unsuccessMsg = String.format(UNSUCCESS_CHECKOUT_MESSAGE, getElementName());
        printer.print("Please Input It's Name:");
        printer.print(checkoutList.getResource().getStockList());
        boolean result = checkoutList.checkoutResource(inputer.getOption());

        if(result) {
            printer.print(successMsg);
        } else {
            printer.print((unsuccessMsg));
        }
    }

    private String getElementName() {
        return checkoutList.getResource().getName();
    }

    @Override
    public String toString() {
        return String.format("%s %s", "Checkout", getElementName());
    }
}

