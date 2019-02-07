package com.twu.biblioteca;

import java.util.Scanner;

class BibliotecaUI {

    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String listOfAllBooksWithAuthorAndPublishedYear = "Rainbirds | Clarissa Goenawan | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "An Ocean of Minutes | Thea Lim | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n";
    private String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Exit";
    private String invalidMessage = "Please select a valid option!";
    private String exitMessage = "Exiting application";

    public void start() {
        printWelcomeMessage();
        printMainMenu();
        selectMenuOption();
    }

    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void printAllBooksWithAuthorAndPublishedYear() {
        System.out.println(listOfAllBooksWithAuthorAndPublishedYear);
    }

    public void printMainMenu() {
        System.out.println(mainMenu);
    }

    public void selectMenuOption() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Integer selection = Integer.parseInt(scanner.next());
            if (selection == 1)
                printAllBooksWithAuthorAndPublishedYear();
            else if (selection == 2) {
                System.out.println(exitMessage);
                break;
            }
            else
                System.out.println(invalidMessage);
        }
    }
}
