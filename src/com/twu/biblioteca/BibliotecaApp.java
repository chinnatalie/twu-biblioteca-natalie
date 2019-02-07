package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void printWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public void printAllBooks() {
        String listOfAllBooks = "Rainbirds by Clarissa Goenawan\n" +
        "Bury What We Cannot Take by Kirsten Chen\n" +
                "An Ocean of Minutes by Thea Lim\n" +
                "The Descent of Monsters (The Tensorate Series) by JY Yang\n" +
                "Ponti by Sharlene Teo\n";
        System.out.println(listOfAllBooks);
    }
}
