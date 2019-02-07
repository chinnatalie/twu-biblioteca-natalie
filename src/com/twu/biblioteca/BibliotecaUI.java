package com.twu.biblioteca;

class BibliotecaUI {

    public void start() {
        printWelcomeMessage();
        printAllBooksWithAuthorAndPublishedYear();
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

    public void printAllBooksWithAuthorAndPublishedYear() {
        String listOfAllBooksWithAuthorAndPublishedYear = "Rainbirds | Clarissa Goenawan | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "An Ocean of Minutes | Thea Lim | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n" +
                "Ponti | Sharlene Teo | 2018\n";
        System.out.println(listOfAllBooksWithAuthorAndPublishedYear);
    }

    public void printMainMenu() {
        String mainMenu = "------- Main menu -------\n" +
                "1) List of books";
        System.out.println(mainMenu);
    }
}
