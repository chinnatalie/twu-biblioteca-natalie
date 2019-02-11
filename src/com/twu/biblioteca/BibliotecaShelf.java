package com.twu.biblioteca;

import java.util.ArrayList;

enum CheckoutStatus {SUCCESS, FAILURE}
enum ReturnStatus {SUCCESS, FAILURE}

public class BibliotecaShelf {

    private enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}
    private ArrayList<BibliotecaBook> books;

    BibliotecaShelf() {
        books = new ArrayList<>();
        books.add(new BibliotecaBook("An Ocean of Minutes", "Thea Lim", "2018"));
        books.add(new BibliotecaBook("Bury What We Cannot Take", "Kirsten Chen", "2018"));
        books.add(new BibliotecaBook( "Ponti", "Sharlene Teo", "2018"));
        books.add(new BibliotecaBook("Rainbirds", "Clarissa Goenawan","2018"));
        books.add(new BibliotecaBook("The Descent of Monsters (The Tensorate Series)", "JY Yang", "2018"));
    }

    String getAllBooks() {
        String result = "";
        for (BibliotecaBook book: books) {
            result += book.getDetails();
            result += "\n";
        }
        return result;
    }

    String getAllAvailableBooks() {
        String result = "";
        for (BibliotecaBook book: books) {
            if (book.getAvailability() == com.twu.biblioteca.AvailabilityStatus.AVAILABLE){
                result += book.getDetails();
                result += "\n";
            }
        }
        return result;
    }

    CheckoutStatus checkoutBook(String bookName) {
        try {
            for (BibliotecaBook book: books) {
                if (book.getName() == bookName && book.getAvailability() == com.twu.biblioteca.AvailabilityStatus.AVAILABLE) {
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
            for (BibliotecaBook book: books) {
                if (book.getName() == bookName && book.getAvailability() == com.twu.biblioteca.AvailabilityStatus.CHECKEDOUT) {
                    book.isReturned();
                    return ReturnStatus.SUCCESS;
                }
            }
            return ReturnStatus.FAILURE;
        } catch (Exception e) {
            return ReturnStatus.FAILURE;
        }
    }

    private boolean isAvailable(AvailabilityStatus status) {
        if (status.equals(AvailabilityStatus.AVAILABLE))
            return true;
        else
            return false;
    }

    private boolean isNotAvailable(AvailabilityStatus status) {
        if (status.equals(AvailabilityStatus.CHECKEDOUT))
            return true;
        else
            return false;
    }
}
