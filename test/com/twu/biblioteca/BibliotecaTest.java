package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaTest {

    public static BibliotecaApp bibliotecaApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void initializeBibliotecaApp() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void shouldSeeWelcomeMessage() {
        bibliotecaApp.printWelcomeMessage();
        assertThat(outContent.toString(),is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }

    @Test
    public void shouldSeeAllBooks() {
        bibliotecaApp.printAllBooks();
        String listOfAllBooks = "Rainbirds by Clarissa Goenawan\n" +
                "Bury What We Cannot Take by Kirsten Chen\n" +
                "An Ocean of Minutes by Thea Lim\n" +
                "The Descent of Monsters (The Tensorate Series) by JY Yang\n" +
                "Ponti by Sharlene Teo\n\n";
        assertThat(outContent.toString(),is(listOfAllBooks));
    }
}
