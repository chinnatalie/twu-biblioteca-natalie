package com.twu.biblioteca;

import java.util.Map;
import java.util.TreeMap;

enum CheckoutStatus {SUCCESS, FAILURE};

public class BibliotecaShelf {

    private enum AvailabilityStatus {AVAILABLE, CHECKEDOUT};
    private TreeMap<String, AvailabilityStatus> books;

    BibliotecaShelf() {
        books = new TreeMap<String, AvailabilityStatus>();
        books.put("Rainbirds | Clarissa Goenawan | 2018", AvailabilityStatus.AVAILABLE);
        books.put("Bury What We Cannot Take | Kirsten Chen | 2018", AvailabilityStatus.AVAILABLE);
        books.put("An Ocean of Minutes | Thea Lim | 2018", AvailabilityStatus.AVAILABLE);
        books.put("The Descent of Monsters (The Tensorate Series) | JY Yang | 2018", AvailabilityStatus.AVAILABLE);
        books.put("Ponti | Sharlene Teo | 2018", AvailabilityStatus.AVAILABLE);
    }

    public String getAllBooks() {
        String result = "";
        for (String book: books.keySet()) {
            result += book;
            result += "\n";
        }
        return result;
    }

    public String getAllAvailableBooks() {
        String result = "";
        for (Map.Entry<String, AvailabilityStatus> entry: books.entrySet()) {
            if (entry.getValue() == AvailabilityStatus.AVAILABLE) {
                result += entry.getKey();
                result += "\n";
            }
        }
        return result;
    }

    public CheckoutStatus checkoutBook(String bookName) {
        AvailabilityStatus bookAvailability = books.get(bookName);
        if (bookAvailability.equals(AvailabilityStatus.AVAILABLE)) {
            books.replace(bookName, AvailabilityStatus.CHECKEDOUT);
            return CheckoutStatus.SUCCESS;
        } else {
            return CheckoutStatus.FAILURE;
        }
    }
}
