package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaShelfTest {

    private BibliotecaShelf bibliotecaShelf;

    private final String listOfAllBooks = "An Ocean of Minutes | Thea Lim | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "Ponti | Sharlene Teo | 2018\n" +
            "Rainbirds | Clarissa Goenawan | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";

    @Before
    public void initializeBibliotecaShelf() {
        bibliotecaShelf = new BibliotecaShelf();
    }

    @Test
    public void shouldReturnAllBooks() {
        assertThat(bibliotecaShelf.getAllBooks(), is(listOfAllBooks));
    }

    @Test
    public void shouldCheckoutBook() {
        bibliotecaShelf.checkoutBook("Rainbirds | Clarissa Goenawan | 2018");
        assertThat(bibliotecaShelf.getAllAvailableBooks(), is("An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Ponti | Sharlene Teo | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n"));
    }

    @Test
    public void shouldReturnSuccessStatusOnCheckout() {
        assertThat(bibliotecaShelf.checkoutBook("Rainbirds | Clarissa Goenawan | 2018"), is(CheckoutStatus.SUCCESS));
    }

    @Test
    public void shouldNotSeeBookAfterCheckout() {
        bibliotecaShelf.checkoutBook("Ponti | Sharlene Teo | 2018");
        String updatedList = "An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Rainbirds | Clarissa Goenawan | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";
        assertThat(bibliotecaShelf.getAllAvailableBooks(), is(updatedList));
    }

    @Test
    public void shouldReturnFailureStatusONCheckoutIfUnavailable() {
        bibliotecaShelf.checkoutBook("Ponti | Sharlene Teo | 2018");
        assertThat(bibliotecaShelf.checkoutBook("Ponti | Sharlene Teo | 2018"), is(CheckoutStatus.FAILURE));
    }
}
