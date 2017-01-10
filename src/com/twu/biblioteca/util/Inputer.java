package com.twu.biblioteca.util;


import java.util.Scanner;

public class Inputer {

    private Scanner scanner;

    public Inputer() {
        this.scanner = new Scanner(System.in);
    }

    public String getOption() {
        return scanner.nextLine();
    }
}
