package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaUITest {

    private static BibliotecaUI bibliotecaUI;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private final String exitMessage = "Exiting application\n";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Check out book\n" +
            "3) Return book\n" +
            "4) List of movies\n" +
            "5) Check out movie\n" +
            "0) Exit\n";

    private final String listOfAllBooksWithAuthorAndPublishedYear = "An Ocean of Minutes | Thea Lim | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n" +
            "Rainbirds | Clarissa Goenawan | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n\n";
    private final String invalidOptionMessage = "Please select a valid option!\n";
    private final String successCheckoutMessage = "Thank you! Enjoy the book\n";
    private final String failureCheckoutMessage = "Sorry, that book is not available";
    private final String checkoutBookQuestion = "Which book do you want to check out?";
    private final String returnBookQuestion = "Which book do you want to return?";
    private final String successReturnMessage = "Thank you for returning the book";
    private final String failureReturnMessage = "That is not a valid book to return.";
    private final String bookName = "The Descent of Monsters (The Tensorate Series)";

    private final String listOfAllMovies = "Ilo Ilo | 2013 | Anthony Chen | 7.3\n" +
            "12 Storeys | 1997 | Eric Khoo | 6.8\n" +
            "I Not Stupid | 2002 | Jack Neo | 7.3\n" +
            "881 | 2007 | Royston Tan | 6.5\n" +
            "Chicken Rice War | 2000 | Chee Kong Cheah | 6.3\n";
    private final String checkOutMovieQuestion = "Which movie do you want to check out?";
    private final String successMovieCheckOutMessage = "Thank you! Enjoy the movie";
    private final String failureMovieCheckOutMessage = "Sorry, that movie is not available";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    private void givenUserInputs(List<String> userInputs) {
        String stringOfInputs = "";
        for(String input: userInputs) {
            stringOfInputs += input;
            stringOfInputs += "\n";
        }
        InputStream inContent = new ByteArrayInputStream(stringOfInputs.getBytes());
        System.setIn(inContent);
    }

    @Before
    public void initializeBibliotecaUI() {
        bibliotecaUI = new BibliotecaUI();
    }

    @Test
    public void shouldSeeWelcomeMessage() {
        bibliotecaUI.printWelcomeMessage();
        assertThat(outContent.toString(),is(welcomeMessage));
    }

    @Test
    public void shouldSeeAllBooksWithAuthorAndPublishedYear() {
        bibliotecaUI.printAllBooksWithAuthorAndPublishedYear();
        assertThat(outContent.toString(),is(listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldSeeMainMenu() {
        bibliotecaUI.printMainMenu();
        assertThat(outContent.toString(),is(mainMenu));
    }

    @Test
    public void shouldSeeWelcomeMessageThenMainMenu() {
        givenUserInputs(Arrays.asList("1", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(),startsWith(welcomeMessage + mainMenu));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedFromMainMenu() {
        givenUserInputs(Arrays.asList("1", "0"));
        bibliotecaUI.selectMenuOption();
        assertThat(outContent.toString(),startsWith(listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldSeeInvalidMessageWhenSelectedOptionIsInvalid() {
        givenUserInputs(Arrays.asList("120", "0"));
        bibliotecaUI.selectMenuOption();
        assertThat(outContent.toString(),startsWith(invalidOptionMessage));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedAfterMainMenu() {
        givenUserInputs(Arrays.asList("1", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(mainMenu + listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldQuitApplicationIfSelected() {
        givenUserInputs(Arrays.asList("1", "1", "1", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(),endsWith(exitMessage));
    }

    @Test
    public void shouldSeeSuccessMessageOnCheckout() {
        bibliotecaUI.checkoutBook(bookName);
        assertThat(outContent.toString(), containsString(successCheckoutMessage));
    }

    @Test
    public void shouldSeeFailureMessageOnCheckout() {
        bibliotecaUI.checkoutBook(bookName);
        bibliotecaUI.checkoutBook(bookName);
        assertThat(outContent.toString(), containsString(failureCheckoutMessage));
    }

    @Test
    public void shouldAskForBookToCheckout() {
        givenUserInputs(Arrays.asList("1", "2", "Ponti", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(checkoutBookQuestion));
    }

    @Test
    public void shouldAskForBookToReturn() {
        givenUserInputs(Arrays.asList("3", "Ponti", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(returnBookQuestion));
    }

    @Test
    public void shouldSeeSuccessMessageOnReturn() {
        bibliotecaUI.checkoutBook(bookName);
        bibliotecaUI.returnBook(bookName);
        assertThat(outContent.toString(), containsString(successReturnMessage));
    }

    @Test
    public void shouldSeeFailureMessageOnReturn() {
        bibliotecaUI.returnBook(bookName);
        assertThat(outContent.toString(), containsString(failureReturnMessage));
    }

    @Test
    public void shouldSeeInvalidMessageWhenSelectedOptionIsNonInteger() {
        givenUserInputs(Arrays.asList("helloworld", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(invalidOptionMessage));
    }

    @Test
    public void shouldSeeAllMoviesIfSelectedFromMaimMenu() {
        givenUserInputs(Arrays.asList("4", "0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(listOfAllMovies));
    }

    @Test
    public void shouldAskForMovieToCheckOut() {
        givenUserInputs(Arrays.asList("5","881","0"));
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(checkOutMovieQuestion));
    }

    @Test
    public void shouldSeeSuccessMessageOnMovieCheckOut() {
        bibliotecaUI.checkOutMovie("881");
        assertThat(outContent.toString(), containsString(successMovieCheckOutMessage));
    }

    @Test
    public void shouldSeeFailureMessageOnMovieCheckOut() {
        bibliotecaUI.checkOutMovie("Spirited Away");
        assertThat(outContent.toString(), containsString(failureMovieCheckOutMessage));
    }
}
