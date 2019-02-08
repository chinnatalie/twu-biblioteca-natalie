package com.twu.biblioteca;

import java.util.Scanner;

class BibliotecaUI {

    private BibliotecaShelf shelf;

    private String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Checkout book\n" +
            "3) Return book\n" +
            "0) Exit";
    private String invalidOptionMessage = "Please select a valid option!";
    private String exitMessage = "Exiting application";
    private String checkoutBookQuestion = "Which book do you want to check out?";
    private String returnBookQuestion = "Which book do you want to return?";
    private String successReturnMessage = "Thank you for returning the book";
    private String failureReturnMessage = "That is not a valid book to return.";
    private String successCheckoutMessage = "Thank you! Enjoy the book";


    BibliotecaUI() {
        shelf = new BibliotecaShelf();
    }

    void start() {
        printWelcomeMessage();
        printMainMenu();
        selectMenuOption();
    }

    void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    void printAllBooksWithAuthorAndPublishedYear() {
        System.out.println(shelf.getAllBooks());
    }

    void printMainMenu() {
        System.out.println(mainMenu);
    }

    void selectMenuOption() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Integer selection = Integer.parseInt(scanner.next());
            if (selection == 1)
                printAllBooksWithAuthorAndPublishedYear();
            else if (selection == 2) {
                System.out.println(checkoutBookQuestion);
                checkoutBook(scanner.next());
            }
            else if (selection == 3) {
                System.out.println(returnBookQuestion);
                returnBook(scanner.next());
            }
            else if (selection == 0) {
                System.out.println(exitMessage);
                break;
            }
            else
                System.out.println(invalidOptionMessage);
        }
    }

    void returnBook(String bookName) {
        switch (shelf.returnBook(bookName)) {
            case SUCCESS:
                System.out.println(successReturnMessage);
                break;
            case FAILURE:
                System.out.println(failureReturnMessage);
                break;
        }
    }

    void checkoutBook(String bookName) {
        switch (shelf.checkoutBook(bookName)) {
            case SUCCESS:
                System.out.println(successCheckoutMessage);
                break;
            case FAILURE:
                System.out.println("Sorry, that book is not available");
                break;
        }
    }
}
