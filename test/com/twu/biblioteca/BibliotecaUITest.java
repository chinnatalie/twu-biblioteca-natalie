package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaUITest {

    private static BibliotecaUI bibliotecaUI;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private final String mainMenu = "------- Main menu -------\n" +
            "1) List of books\n";
    private final String listOfAllBooksWithAuthorAndPublishedYear = "Rainbirds | Clarissa Goenawan | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "An Ocean of Minutes | Thea Lim | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n\n";
    private final String invalidMessage = "Please select a valid option!\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void initializeBibliotecaApp() {
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

    @Ignore
    @Test
    public void shouldSeeWelcomeMessageThenMainMenu() {
        bibliotecaUI.start();
        assertThat(outContent.toString(),is(welcomeMessage + mainMenu));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedFromMainMenu() {
        String userInput = "1";
        bibliotecaUI.selectMenuOption(userInput);
        assertThat(outContent.toString(),is(listOfAllBooksWithAuthorAndPublishedYear));
    }

    @Test
    public void shouldSeeInvalidMessageWhenSelectedOptionIsInvalid() {
        String userInput = "120";
        bibliotecaUI.selectMenuOption(userInput);
        assertThat(outContent.toString(),is(invalidMessage));
    }

    @Test
    public void shouldSeeAllBooksIfSelectedAfterMainMenu() {
        String userInput = "1";
        InputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);
        bibliotecaUI.start();
        assertThat(outContent.toString(), endsWith(listOfAllBooksWithAuthorAndPublishedYear));
    }
}
