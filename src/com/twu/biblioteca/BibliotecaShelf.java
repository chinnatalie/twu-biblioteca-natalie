package com.twu.biblioteca;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

enum CheckoutStatus {SUCCESS, FAILURE}
enum ReturnStatus {SUCCESS, FAILURE}

public class BibliotecaShelf {

    private enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}
    private TreeMap<String, AvailabilityStatus> books;

    BibliotecaShelf() {
        books = new TreeMap<String, AvailabilityStatus>();
        books.put("Rainbirds | Clarissa Goenawan | 2018", AvailabilityStatus.AVAILABLE);
        books.put("Bury What We Cannot Take | Kirsten Chen | 2018", AvailabilityStatus.AVAILABLE);
        books.put("An Ocean of Minutes | Thea Lim | 2018", AvailabilityStatus.AVAILABLE);
        books.put("The Descent of Monsters (The Tensorate Series) | JY Yang | 2018", AvailabilityStatus.AVAILABLE);
        books.put("Ponti | Sharlene Teo | 2018", AvailabilityStatus.AVAILABLE);
    }

    String getAllBooks() {
        String result = "";
        Set<String> listOfAllBooks = books.keySet();
        for (String book: listOfAllBooks) {
            result += book;
            result += "\n";
        }
        return result;
    }

    String getAllAvailableBooks() {
        String result = "";
        Set<Map.Entry<String, AvailabilityStatus>> listOfAllBooksWithStatus = books.entrySet();
        for (Map.Entry<String, AvailabilityStatus> entry: listOfAllBooksWithStatus) {
            if (isAvailable(entry.getValue())) {
                result += entry.getKey();
                result += "\n";
            }
        }
        return result;
    }

    CheckoutStatus checkoutBook(String bookName) {
        try {
            AvailabilityStatus bookAvailability = books.get(bookName);
            if (isAvailable(bookAvailability)) {
                books.replace(bookName, AvailabilityStatus.CHECKEDOUT);
                return CheckoutStatus.SUCCESS;
            } else {
                return CheckoutStatus.FAILURE;
            }
        } catch (Exception e) {
            return CheckoutStatus.FAILURE;
        }
    }

    ReturnStatus returnBook(String bookName) {
        try {
            AvailabilityStatus bookAvailability = books.get(bookName);
            if (isNotAvailable(bookAvailability)) {
                books.replace(bookName, AvailabilityStatus.AVAILABLE);
                return ReturnStatus.SUCCESS;
            } else {
                return ReturnStatus.FAILURE;
            }
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
