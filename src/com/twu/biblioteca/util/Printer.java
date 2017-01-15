package com.twu.biblioteca.util;

import java.util.List;

public class Printer{

    public void print(String message) {
        System.out.println(message);
    }

    public void print(List list){
        list.stream().forEach(object -> print(object.toString()));
    }
}
