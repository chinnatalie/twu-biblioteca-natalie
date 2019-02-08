package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaUITest {

    private static BibliotecaUI bibliotecaUI;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n" +
            "2) Checkout book\n" +
            "3) Return book\n" +
            "0) Exit\n";
    private final String listOfAllBooksWithAuthorAndPublishedYear = "An Ocean of Minutes | Thea Lim | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n" +
            "Rainbirds | Clarissa Goenawan | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n\n";
    private final String invalidMessage = "Please select a valid option!\n";
    private final String bookName = "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    private void givenUserInputs(String userInput) {
        InputStream inContent = new ByteArrayInputStream(userInput.getBytes());
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
        givenUserInputs("1\n0");
        bibliotecaUI.start();
        assertThat(outContent.toString(),startsWith(welcomeMessage + mainMenu));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedFromMainMenu() {
        givenUserInputs("1\n0");
        bibliotecaUI.selectMenuOption();
        assertThat(outContent.toString(),startsWith(listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldSeeInvalidMessageWhenSelectedOptionIsInvalid() {
        givenUserInputs("120\n0");
        bibliotecaUI.selectMenuOption();
        assertThat(outContent.toString(),startsWith(invalidMessage));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedAfterMainMenu() {
        givenUserInputs("1\n0");
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString(mainMenu + listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldQuitApplicationIfSelected() {
        givenUserInputs("1\n1\n1\n0");
        bibliotecaUI.start();
        assertThat(outContent.toString(),endsWith("Exiting application\n"));
    }

    @Test
    public void shouldSeeSuccessMessageOnCheckout() {
        bibliotecaUI.checkoutBook(bookName);
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book\n"));
    }

    @Test
    public void shouldSeeFailureMessageOnCheckout() {
        bibliotecaUI.checkoutBook(bookName);
        bibliotecaUI.checkoutBook(bookName);
        assertThat(outContent.toString(), containsString("Sorry, that book is not available"));
    }

    @Test
    public void shouldAskForBookToCheckout() {
        givenUserInputs("1\n2\nPonti\n0");
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString("Which book do you want to check out?"));
    }

    @Test
    public void shouldAskForBookToReturn() {
        givenUserInputs("3\nPonti\n0\n");
        bibliotecaUI.start();
        assertThat(outContent.toString(), containsString("Which book do you want to return?"));
    }

    @Test
    public void shouldSeeSuccessMessageOnReturn() {
        bibliotecaUI.checkoutBook(bookName);
        bibliotecaUI.returnBook(bookName);
        assertThat(outContent.toString(), containsString("Thank you for returning the book"));
    }

    @Test
    public void shouldSeeFailureMessageOnReturn() {
        bibliotecaUI.returnBook(bookName);
        assertThat(outContent.toString(), containsString("That is not a valid book to return."));
    }
}
