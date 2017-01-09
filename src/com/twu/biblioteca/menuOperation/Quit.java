package com.twu.biblioteca.menuOperation;

public class Quit implements Operation {

    @Override
    public void operate() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
