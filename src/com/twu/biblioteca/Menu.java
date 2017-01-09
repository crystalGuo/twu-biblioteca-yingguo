package com.twu.biblioteca;

import com.twu.biblioteca.menuOperation.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Menu {

    private Map<Integer, Operation> menu;

    public Menu(Map<Integer, Operation> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        menu.entrySet().stream().forEach(entry ->
                result.add(String.format("%d\t%s", entry.getKey(), entry.getValue())));

        return String.join("\n",result);
    }

    public boolean isValid(int option) {
        return menu.containsKey(option);
    }
}
