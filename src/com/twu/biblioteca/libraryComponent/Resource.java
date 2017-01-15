package com.twu.biblioteca.libraryComponent;

import com.twu.biblioteca.libraryComponent.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Resource<T extends Item> {

    private List<T> stockList;
    private List<T> checkoutList;
    private String name;

    public Resource(List<T> stockList, String name) {
        this.stockList = stockList;
        this.checkoutList = new ArrayList<T>();
        this.name = name;
    }

    public boolean canReturn(String name) {
        return find(name, checkoutList).isPresent();
    }

    public boolean canCheckout(String name) {
        return find(name, stockList).isPresent();
    }

    public Optional find(String name, List<T> list) {
        return list.stream().filter(resource -> name.equals(resource.getName())).findFirst();
    }

    public List<T> getStockList() {
        return stockList;
    }

    public List<T> getCheckoutList() {
        return checkoutList;
    }

    public String getName() {
        return name;
    }
}
