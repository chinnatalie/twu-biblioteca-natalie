package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaShelfTest {

    private BibliotecaShelf bibliotecaShelf;
    private BibliotecaShelf bibliotecaMovieShelf;

    private final String listOfAllBooks = "An Ocean of Minutes | Thea Lim | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n" +
            "Rainbirds | Clarissa Goenawan | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";
    private final String listOfAllMovies = "Ilo Ilo | 2013 | Anthony Chen | 7.3\n";

    @Before
    public void initializeBibliotecaShelf() {
        bibliotecaShelf = new BibliotecaShelf();
        ArrayList<BibliotecaResource> movieList = new ArrayList<>();
        movieList.add(new BibliotecaMovie("Ilo Ilo", "2013", "Anthony Chen", "7.3"));
        bibliotecaMovieShelf = new BibliotecaShelf(movieList);
    }

    @Test
    public void shouldReturnAllBooks() {
        assertThat(bibliotecaShelf.getAllBooks(), is(listOfAllBooks));
    }

    @Test
    public void shouldCheckoutBook() {
        bibliotecaShelf.checkoutBook("Rainbirds");
        assertThat(bibliotecaShelf.getAllAvailableBooks(), is("An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Ponti | Sharlene Teo | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n"));
    }

    @Test
    public void shouldReturnSuccessStatusOnCheckout() {
        assertThat(bibliotecaShelf.checkoutBook("Rainbirds"), is(CheckoutStatus.SUCCESS));
    }

    @Test
    public void shouldNotSeeBookAfterCheckout() {
        bibliotecaShelf.checkoutBook("Ponti");
        String updatedList = "An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Rainbirds | Clarissa Goenawan | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";
        assertThat(bibliotecaShelf.getAllAvailableBooks(), is(updatedList));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfUnavailable() {
        bibliotecaShelf.checkoutBook("Ponti");
        assertThat(bibliotecaShelf.checkoutBook("Ponti | Sharlene Teo | 2018"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfNonExistent() {
        assertThat(bibliotecaShelf.checkoutBook("The Great Gatsby"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnSuccessStatusOnReturn() {
        bibliotecaShelf.checkoutBook("Ponti");
        assertThat(bibliotecaShelf.returnBook("Ponti"), is(ReturnStatus.SUCCESS));
    }

    @Test
    public void shouldSeeBookAfterReturn() {
        bibliotecaShelf.checkoutBook("Ponti");
        bibliotecaShelf.returnBook("Ponti");
        assertThat(bibliotecaShelf.getAllAvailableBooks(), is(listOfAllBooks));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotCheckedOut() {
        assertThat(bibliotecaShelf.returnBook("Ponti"), is(ReturnStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotExistent() {
        assertThat(bibliotecaShelf.returnBook("The Great Gatsby"), is(ReturnStatus.FAILURE));
    }

    @Test
    public void shouldReturnAllMovies() {
        assertThat(bibliotecaMovieShelf.getAllResources(), is(listOfAllMovies));
    }
}
