package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BibliotecaUI {

    private BibliotecaShelf bookShelf;
    private BibliotecaShelf movieShelf;

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Checkout book\n" +
            "3) Return book\n" +
            "4) List of movies\n" +
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
        bookShelf = new BibliotecaShelf();
        movieShelf = new BibliotecaShelf(Arrays.asList(
                new BibliotecaMovie("Ilo Ilo", "2013", "Anthony Chen", "7.3"),
                new BibliotecaMovie("12 Storeys", "1997", "Eric Khoo", "6.8")));
    }

    void start() {
        printWelcomeMessage();
        printMainMenu();
        selectMenuOption();
    }

    void printWelcomeMessage() {
        print(welcomeMessage);
    }

    void printAllBooksWithAuthorAndPublishedYear() {
        print(bookShelf.getAllResources());
    }

    void printMainMenu() {
        print(mainMenu);
    }

    void selectMenuOption() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Integer selection = getOptionSelected(scanner.next());
            if (selection == 1)
                printAllBooksWithAuthorAndPublishedYear();
            else if (selection == 2) {
                print(checkoutBookQuestion);
                checkoutBook(scanner.next());
            }
            else if (selection == 3) {
                print(returnBookQuestion);
                returnBook(scanner.next());
            }
            else if (selection == 4) {
                print(movieShelf.getAllAvailableResources());
            }
            else if (selection == 0) {
                print(exitMessage);
                break;
            }
            else
                print(invalidOptionMessage);
        }
    }

    void returnBook(String bookName) {
        ReturnStatus returnStatus = bookShelf.returnBook(bookName);
        switch (returnStatus) {
            case SUCCESS:
                print(successReturnMessage);
                break;
            case FAILURE:
                print(failureReturnMessage);
                break;
        }
    }

    void checkoutBook(String bookName) {
        CheckoutStatus checkoutStatus = bookShelf.checkoutBook(bookName);
        switch (checkoutStatus) {
            case SUCCESS:
                print(successCheckoutMessage);
                break;
            case FAILURE:
                print(failureCheckoutMessage);
                break;
        }
    }

    private int getOptionSelected(String userInput) {
        Integer selection;
        try {
            selection = Integer.parseInt(userInput);
        } catch (Exception e) {
            selection = -1;
        }
        return selection;
    }

    private void print(String message) {
        System.out.println(message);
    }
}
