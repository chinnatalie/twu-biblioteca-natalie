package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

class BibliotecaUI {

    private static BibliotecaAccountManager accountManager = new BibliotecaAccountManager();

    private BibliotecaShelf bookShelf;
    private BibliotecaShelf movieShelf;

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Check out book\n" +
            "3) Return book\n" +
            "4) List of movies\n" +
            "5) Check out movie\n" +
            "6) Books on loan\n" +
            "7) Account details\n" +
            "9) All book loans (librarians only)\n" +
            "0) Exit";
    private final String invalidOptionMessage = "Please select a valid option!";
    private final String exitMessage = "Exiting application";
    private final String checkoutBookQuestion = "Which book do you want to check out?";
    private final String returnBookQuestion = "Which book do you want to return?";
    private final String successReturnMessage = "Thank you for returning the book";
    private final String failureReturnMessage = "That is not a valid book to return.";
    private final String successCheckoutMessage = "Thank you! Enjoy the book";
    private final String failureCheckoutMessage = "Sorry, that book is not available";

    private final String checkOutMovieQuestion = "Which movie do you want to check out?";
    private final String successMovieCheckOutMessage = "Thank you! Enjoy the movie";
    private final String failureMovieCheckOutMessage = "Sorry, that movie is not available";

    private final String loginMessage = "You need to login to use Biblioteca.";
    private final String loginNumberQuestion = "Your library number: ";
    private final String loginPasswordQuestion = "Your password: ";
    private final String successLoginMessage = "You have logged in successfully!";
    private final String failureLoginMessage = "You have entered the wrong details!";
    private final String unauthorizedMessage = "You are not authorized to view this!";

    private static Scanner scanner;

    BibliotecaUI() {
        bookShelf = new BibliotecaShelf(Arrays.asList(
                new BibliotecaBook("An Ocean of Minutes", "Thea Lim", "2018"),
                new BibliotecaBook("Bury What We Cannot Take", "Kirsten Chen", "2018"),
                new BibliotecaBook( "Ponti", "Sharlene Teo", "2018"),
                new BibliotecaBook("Rainbirds", "Clarissa Goenawan","2018"),
                new BibliotecaBook("The Descent of Monsters (The Tensorate Series)", "JY Yang", "2018")
        ));
        movieShelf = new BibliotecaShelf(Arrays.asList(
                new BibliotecaMovie("Ilo Ilo", "2013", "Anthony Chen", "7.3"),
                new BibliotecaMovie("12 Storeys", "1997", "Eric Khoo", "6.8"),
                new BibliotecaMovie("I Not Stupid", "2002", "Jack Neo", "7.3"),
                new BibliotecaMovie("881", "2007", "Royston Tan", "6.5"),
                new BibliotecaMovie("Chicken Rice War", "2000", "Chee Kong Cheah", "6.3")));
    }

    void start() {
        openScanner();
        print(welcomeMessage);
        login();
        printMainMenu();
        selectMenuOption();
    }

    void login() {
        while (true) {
            print(loginMessage);
            print(loginNumberQuestion);
            String libraryNumber = scanner.nextLine();
            print(loginPasswordQuestion);
            String password = scanner.nextLine();
            if (accountManager.loginUser(libraryNumber, password)) {
                print(successLoginMessage);
                break;
            } else
                print(failureLoginMessage);
        }
    }

    void selectMenuOption() {
        while(true) {
            Integer selection = getOptionSelected(scanner.nextLine());
            if (selection == 1)
                printAllBooksWithAuthorAndPublishedYear();
            else if (selection == 2) {
                checkoutBook();
            }
            else if (selection == 3) {
                returnBook();
            }
            else if (selection == 4) {
                print(movieShelf.getAllAvailableResources());
            }
            else if (selection == 5) {
                checkOutMovie();
            }
            else if (selection == 6) {
                printCheckedOutBooks();
            }
            else if (selection == 7)
                print(accountManager.getLoggedInUserDetails());
            else if (selection == 9) {
                printAllCheckedOutBooksIfLibrarian();
            }
            else if (selection == 0) {
                print(exitMessage);
                break;
            }
            else
                print(invalidOptionMessage);
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

    private void printAllCheckedOutBooksIfLibrarian() {
        if (accountManager.isLoggedInByLibrarian())
            print(bookShelf.getAllCheckedOutResources());
        else
            print(unauthorizedMessage);
    }

    void checkoutBook() {
        print(checkoutBookQuestion);
        String bookToCheckOut = scanner.nextLine();
        String borrower = accountManager.getLoggedInUser();
        CheckoutStatus checkoutStatus = bookShelf.checkoutResource(borrower, bookToCheckOut);
        switch (checkoutStatus) {
            case SUCCESS:
                print(successCheckoutMessage);
                break;
            case FAILURE:
                print(failureCheckoutMessage);
                break;
        }
    }

    void returnBook() {
        print(returnBookQuestion);
        String bookToReturn = scanner.nextLine();
        ReturnStatus returnStatus = bookShelf.returnResource(bookToReturn);
        switch (returnStatus) {
            case SUCCESS:
                print(successReturnMessage);
                break;
            case FAILURE:
                print(failureReturnMessage);
                break;
        }
    }

    void checkOutMovie() {
        print(checkOutMovieQuestion);
        String movieToCheckOut = scanner.nextLine();
        String borrower = accountManager.getLoggedInUser();
        CheckoutStatus checkOutStatus = movieShelf.checkoutResource(borrower, movieToCheckOut);
        switch (checkOutStatus) {
            case SUCCESS:
                print(successMovieCheckOutMessage);
                break;
            case FAILURE:
                print(failureMovieCheckOutMessage);
                break;
        }
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

    private void printCheckedOutBooks() {
        String libraryNumber = accountManager.getLoggedInUser();
        String listOfBooks = bookShelf.getAllCheckedOutResourcesOfUser(libraryNumber);
        print(listOfBooks);
    }

    private void print(String message) { System.out.println(message); }

    void openScanner() {
        scanner = new Scanner(System.in);
    }
}
