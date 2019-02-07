package com.twu.biblioteca;

import java.util.Map;
import java.util.TreeMap;

public class BibliotecaShelf {

    private enum Status {AVAILABLE, CHECKEDOUT};
    private TreeMap<String, Status> books;

    BibliotecaShelf() {
        books = new TreeMap<String, Status>();
        books.put("Rainbirds | Clarissa Goenawan | 2018", Status.AVAILABLE);
        books.put("Bury What We Cannot Take | Kirsten Chen | 2018", Status.AVAILABLE);
        books.put("An Ocean of Minutes | Thea Lim | 2018", Status.AVAILABLE);
        books.put("The Descent of Monsters (The Tensorate Series) | JY Yang | 2018", Status.AVAILABLE);
        books.put("Ponti | Sharlene Teo | 2018", Status.AVAILABLE);
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
        for (Map.Entry<String, Status> entry: books.entrySet()) {
            if (entry.getValue() == Status.AVAILABLE) {
                result += entry.getKey();
                result += "\n";
            }
        }
        return result;
    }

    public String checkoutBook(String book) {
        if (books.get(book) == Status.AVAILABLE) {
            books.replace(book, Status.CHECKEDOUT);
            return "Thank you! Enjoy the book";
        } else {
            return "";
        }
    }
}
