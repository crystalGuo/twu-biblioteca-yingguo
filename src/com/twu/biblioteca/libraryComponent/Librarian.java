package com.twu.biblioteca.libraryComponent;

import com.twu.biblioteca.libraryComponent.Resource;

public class Librarian {

    private Resource resource;

    public Librarian(Resource resource) {
        this.resource = resource;
    }

    public boolean checkoutResource(String name) {
        if(resource.canCheckout(name)) {
            Object checkoutResource = resource.find(name, resource.getStockList()).get();
            resource.getStockList().remove(checkoutResource);
            resource.getCheckoutList().add(checkoutResource);

            return true;
        }

        return false;
    }

    public boolean returnResource(String name) {
        if(resource.canReturn(name)) {
            Object returnResource = resource.find(name, resource.getCheckoutList()).get();
            resource.getCheckoutList().remove(returnResource);
            resource.getStockList().add(returnResource);

            return true;
        }

        return  false;
    }

    public Resource getResource() {
        return resource;
    }
}
