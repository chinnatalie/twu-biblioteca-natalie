package com.twu.biblioteca;

import java.util.Scanner;

class BibliotecaUI {

    private BibliotecaShelf shelf;

    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Exit";
    private String invalidMessage = "Please select a valid option!";
    private String exitMessage = "Exiting application";

    BibliotecaUI() {
        shelf = new BibliotecaShelf();
    }

    public void start() {
        printWelcomeMessage();
        printMainMenu();
        selectMenuOption();
    }

    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public void printAllBooksWithAuthorAndPublishedYear() {
        System.out.println(shelf.getAllBooks());
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
