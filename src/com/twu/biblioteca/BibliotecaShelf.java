package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

enum CheckoutStatus {SUCCESS, FAILURE}
enum ReturnStatus {SUCCESS, FAILURE}

public class BibliotecaShelf {

    private ArrayList<BibliotecaResource> resources;

    BibliotecaShelf() {
        resources = new ArrayList<>();
        resources.add(new BibliotecaBook("An Ocean of Minutes", "Thea Lim", "2018"));
        resources.add(new BibliotecaBook("Bury What We Cannot Take", "Kirsten Chen", "2018"));
        resources.add(new BibliotecaBook( "Ponti", "Sharlene Teo", "2018"));
        resources.add(new BibliotecaBook("Rainbirds", "Clarissa Goenawan","2018"));
        resources.add(new BibliotecaBook("The Descent of Monsters (The Tensorate Series)", "JY Yang", "2018"));
    }

    BibliotecaShelf(List<BibliotecaResource> resources) {
        this.resources = new ArrayList<>(resources);
    }

    public String getAllResources() {
        String result = "";
        for (BibliotecaResource book: resources) {
            result += book.getDetails();
            result += "\n";
        }
        return result;
    }

    String getAllAvailableResources() {
        String result = "";
        for (BibliotecaResource book: resources) {
            if (book.isAvailable()){
                result += book.getDetails();
                result += "\n";
            }
        }
        return result;
    }

    CheckoutStatus checkoutResource(String resourceName) {
        try {
            for (BibliotecaResource resource: resources) {
                if (resource.getName() == resourceName && resource.isAvailable()) {
                    resource.checkOut("123-4567");
                    return CheckoutStatus.SUCCESS;
                }
            }
            return CheckoutStatus.FAILURE;
        } catch (Exception e) {
            return CheckoutStatus.FAILURE;
        }
    }

    ReturnStatus returnResource(String bookResource) {
        try {
            for (BibliotecaResource resource: resources) {
                if (resource.getName() == bookResource && resource.isCheckedOut()) {
                    resource.isReturned();
                    return ReturnStatus.SUCCESS;
                }
            }
            return ReturnStatus.FAILURE;
        } catch (Exception e) {
            return ReturnStatus.FAILURE;
        }
    }
}
