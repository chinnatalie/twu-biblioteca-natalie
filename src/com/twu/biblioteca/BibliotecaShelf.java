package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaShelf {

    private List<String> listOfBooks;

    BibliotecaShelf() {
        listOfBooks = new ArrayList<String>();
        listOfBooks.add("Rainbirds | Clarissa Goenawan | 2018");
        listOfBooks.add("Bury What We Cannot Take | Kirsten Chen | 2018");
        listOfBooks.add("An Ocean of Minutes | Thea Lim | 2018");
        listOfBooks.add("The Descent of Monsters (The Tensorate Series) | JY Yang | 2018");
        listOfBooks.add("Ponti | Sharlene Teo | 2018");
    }

    public String getAllBooks() {
        String result = "";
        for (String book: listOfBooks) {
            result += book;
            result += "\n";
        }
        return result;
    }
}
