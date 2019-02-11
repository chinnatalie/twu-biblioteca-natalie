package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

enum CheckoutStatus {SUCCESS, FAILURE}
enum ReturnStatus {SUCCESS, FAILURE}

public class BibliotecaShelf {

    private ArrayList<BibliotecaResource> books;

    BibliotecaShelf() {
        books = new ArrayList<>();
        books.add(new BibliotecaBook("An Ocean of Minutes", "Thea Lim", "2018"));
        books.add(new BibliotecaBook("Bury What We Cannot Take", "Kirsten Chen", "2018"));
        books.add(new BibliotecaBook( "Ponti", "Sharlene Teo", "2018"));
        books.add(new BibliotecaBook("Rainbirds", "Clarissa Goenawan","2018"));
        books.add(new BibliotecaBook("The Descent of Monsters (The Tensorate Series)", "JY Yang", "2018"));
    }

    BibliotecaShelf(ArrayList<BibliotecaResource> resources) {
        books = resources;
    }

    BibliotecaShelf(List<BibliotecaResource> resources) {
        books = new ArrayList<>(resources);
    }

    public String getAllResources() {
        String result = "";
        for (BibliotecaResource book: books) {
            result += book.getDetails();
            result += "\n";
        }
        return result;
    }

    String getAllAvailableResources() {
        String result = "";
        for (BibliotecaResource book: books) {
            if (book.isAvailable()){
                result += book.getDetails();
                result += "\n";
            }
        }
        return result;
    }

    CheckoutStatus checkoutBook(String bookName) {
        try {
            for (BibliotecaResource book: books) {
                if (book.getName() == bookName && book.isAvailable()) {
                    book.checkOut();
                    return CheckoutStatus.SUCCESS;
                }
            }
            return CheckoutStatus.FAILURE;
        } catch (Exception e) {
            return CheckoutStatus.FAILURE;
        }
    }

    ReturnStatus returnBook(String bookName) {
        try {
            for (BibliotecaResource book: books) {
                if (book.getName() == bookName && book.isCheckedOut()) {
                    book.isReturned();
                    return ReturnStatus.SUCCESS;
                }
            }
            return ReturnStatus.FAILURE;
        } catch (Exception e) {
            return ReturnStatus.FAILURE;
        }
    }
}
