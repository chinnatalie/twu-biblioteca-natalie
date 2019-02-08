package com.twu.biblioteca;

import java.util.Scanner;

class BibliotecaUI {

    private BibliotecaShelf shelf;

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Checkout book\n" +
            "3) Return book\n" +
            "0) Exit";
    private final String invalidOptionMessage = "Please select a valid option!";
    private final String exitMessage = "Exiting application";
    private final String checkoutBookQuestion = "Which book do you want to check out?";
    private final String returnBookQuestion = "Which book do you want to return?";
    private final String successReturnMessage = "Thank you for returning the book";
    private final String failureReturnMessage = "That is not a valid book to return.";
    private final String successCheckoutMessage = "Thank you! Enjoy the book";
    private final String failureCheckoutMessage = "Sorry, that book is not available";


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
        ReturnStatus returnStatus = shelf.returnBook(bookName);
        switch (returnStatus) {
            case SUCCESS:
                System.out.println(successReturnMessage);
                break;
            case FAILURE:
                System.out.println(failureReturnMessage);
                break;
        }
    }

    void checkoutBook(String bookName) {
        CheckoutStatus checkoutStatus = shelf.checkoutBook(bookName);
        switch (checkoutStatus) {
            case SUCCESS:
                System.out.println(successCheckoutMessage);
                break;
            case FAILURE:
                System.out.println(failureCheckoutMessage);
                break;
        }
    }
}
