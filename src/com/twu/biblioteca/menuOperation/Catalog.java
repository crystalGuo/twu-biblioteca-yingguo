package com.twu.biblioteca.menuOperation;

import com.twu.biblioteca.util.Printer;

public class Catalog implements Operation{

    private BookList bookList;
    private Printer printer;

    public Catalog(BookList bookList, Printer printer) {
        this.bookList = bookList;
        this.printer = printer;
    }

    @Override
    public void operate() {
        printer.print(bookList.getBookList());
    }

    @Override
    public String toString() {
        return "Catalog";
    }
}
