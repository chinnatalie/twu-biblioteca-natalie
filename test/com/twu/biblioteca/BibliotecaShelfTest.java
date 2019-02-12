package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    private final String listOfAllMovies = "Ilo Ilo | 2013 | Anthony Chen | 7.3\n" +
            "12 Storeys | 1997 | Eric Khoo | 6.8\n" +
            "I Not Stupid | 2002 | Jack Neo | 7.3\n" +
            "881 | 2007 | Royston Tan | 6.5\n" +
            "Chicken Rice War | 2000 | Chee Kong Cheah | 6.3\n";
    private final String borrower = "123-4567";
    private final String listOfAllCheckedOutBooks = "Ponti | 123-4567\n" +
            "Rainbirds | 123-4567\n";

    @Before
    public void initializeBibliotecaShelf() {
        bibliotecaShelf = new BibliotecaShelf();
        bibliotecaMovieShelf = new BibliotecaShelf(Arrays.asList(
                new BibliotecaMovie("Ilo Ilo", "2013", "Anthony Chen", "7.3"),
                new BibliotecaMovie("12 Storeys", "1997", "Eric Khoo", "6.8"),
                new BibliotecaMovie("I Not Stupid", "2002", "Jack Neo", "7.3"),
                new BibliotecaMovie("881", "2007", "Royston Tan", "6.5"),
                new BibliotecaMovie("Chicken Rice War", "2000", "Chee Kong Cheah", "6.3")));
    }

    @Test
    public void shouldReturnAllBooks() {
        assertThat(bibliotecaShelf.getAllResources(), is(listOfAllBooks));
    }

    @Test
    public void shouldCheckoutBook() {
        bibliotecaShelf.checkoutResource(borrower, "Rainbirds");
        assertThat(bibliotecaShelf.getAllAvailableResources(), is("An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Ponti | Sharlene Teo | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n"));
    }

    @Test
    public void shouldReturnSuccessStatusOnCheckout() {
        assertThat(bibliotecaShelf.checkoutResource(borrower, "Rainbirds"), is(CheckoutStatus.SUCCESS));
    }

    @Test
    public void shouldNotSeeBookAfterCheckout() {
        bibliotecaShelf.checkoutResource(borrower, "Ponti");
        String updatedList = "An Ocean of Minutes | Thea Lim | 2018\n" +
                "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
                "Rainbirds | Clarissa Goenawan | 2018\n" +
                "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";
        assertThat(bibliotecaShelf.getAllAvailableResources(), is(updatedList));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfUnavailable() {
        bibliotecaShelf.checkoutResource(borrower, "Ponti");
        assertThat(bibliotecaShelf.checkoutResource(borrower, "Ponti | Sharlene Teo | 2018"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfNonExistent() {
        assertThat(bibliotecaShelf.checkoutResource(borrower, "The Great Gatsby"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnSuccessStatusOnReturn() {
        bibliotecaShelf.checkoutResource(borrower,"Ponti");
        assertThat(bibliotecaShelf.returnResource("Ponti"), is(ReturnStatus.SUCCESS));
    }

    @Test
    public void shouldSeeBookAfterReturn() {
        bibliotecaShelf.checkoutResource(borrower,"Ponti");
        bibliotecaShelf.returnResource("Ponti");
        assertThat(bibliotecaShelf.getAllAvailableResources(), is(listOfAllBooks));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotCheckedOut() {
        assertThat(bibliotecaShelf.returnResource("Ponti"), is(ReturnStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotExistent() {
        assertThat(bibliotecaShelf.returnResource("The Great Gatsby"), is(ReturnStatus.FAILURE));
    }

    @Test
    public void shouldReturnAllMovies() {
        assertThat(bibliotecaMovieShelf.getAllResources(), is(listOfAllMovies));
    }

    @Test
    public void shouldReturnSuccessStatusOnMovieCheckOut() {
        assertThat(bibliotecaMovieShelf.checkoutResource(borrower,"881"), is(CheckoutStatus.SUCCESS));
    }

    @Test
    public void shouldReturnFailureStatusOnMovieCheckOut() {
        assertThat(bibliotecaMovieShelf.checkoutResource(borrower,"Spirited Away"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldSeeAllCheckedOutBooks() {
        bibliotecaShelf.checkoutResource(borrower, "Ponti");
        bibliotecaShelf.checkoutResource(borrower, "Rainbirds");
        assertThat(bibliotecaShelf.getAllCheckedOutResources(), is(listOfAllCheckedOutBooks));
    }
}
