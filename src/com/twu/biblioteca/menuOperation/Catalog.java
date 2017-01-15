package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.libraryComponent.Librarian;
import com.twu.biblioteca.util.Printer;

public class Catalog implements Operation{

    private Librarian librarian;
    private Printer printer;

    public Catalog(Librarian librarian, Printer printer) {
        this.librarian = librarian;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(librarian.getResource().getStockList());
    }

    @Override
    public String toString() {
        return "Catalog";
    }
}
