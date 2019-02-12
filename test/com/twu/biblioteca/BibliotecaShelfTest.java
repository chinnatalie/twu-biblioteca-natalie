package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaShelfTest {

    private BibliotecaShelf bibliotecaBookShelf;
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
    private final String book = "Ponti";
    private final String updatedList = "An Ocean of Minutes | Thea Lim | 2018\n" +
            "Bury What We Cannot Take | Kirsten Chen | 2018\n" +
            "Rainbirds | Clarissa Goenawan | 2018\n" +
            "The Descent of Monsters (The Tensorate Series) | JY Yang | 2018\n";

    @Before
    public void initializeBibliotecaShelf() {
        bibliotecaBookShelf = new BibliotecaShelf();
        bibliotecaMovieShelf = new BibliotecaShelf(Arrays.asList(
                new BibliotecaMovie("Ilo Ilo", "2013", "Anthony Chen", "7.3"),
                new BibliotecaMovie("12 Storeys", "1997", "Eric Khoo", "6.8"),
                new BibliotecaMovie("I Not Stupid", "2002", "Jack Neo", "7.3"),
                new BibliotecaMovie("881", "2007", "Royston Tan", "6.5"),
                new BibliotecaMovie("Chicken Rice War", "2000", "Chee Kong Cheah", "6.3")));
    }

    @Test
    public void shouldReturnAllBooks() {
        assertThat(bibliotecaBookShelf.getAllResources(), is(listOfAllBooks));
    }

    @Test
    public void shouldCheckoutBook() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        assertThat(bibliotecaBookShelf.getAllAvailableResources(), is(updatedList));
    }

    @Test
    public void shouldReturnSuccessStatusOnCheckout() {
        assertThat(bibliotecaBookShelf.checkoutResource(borrower, book), is(CheckoutStatus.SUCCESS));
    }

    @Test
    public void shouldNotSeeBookAfterCheckout() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        assertThat(bibliotecaBookShelf.getAllAvailableResources(), is(updatedList));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfUnavailable() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        assertThat(bibliotecaBookShelf.checkoutResource(borrower, "Ponti | Sharlene Teo | 2018"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnCheckoutIfNonExistent() {
        assertThat(bibliotecaBookShelf.checkoutResource(borrower, "The Great Gatsby"), is(CheckoutStatus.FAILURE));
    }

    @Test
    public void shouldReturnSuccessStatusOnReturn() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        assertThat(bibliotecaBookShelf.returnResource(book), is(ReturnStatus.SUCCESS));
    }

    @Test
    public void shouldSeeBookAfterReturn() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        bibliotecaBookShelf.returnResource(book);
        assertThat(bibliotecaBookShelf.getAllAvailableResources(), is(listOfAllBooks));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotCheckedOut() {
        assertThat(bibliotecaBookShelf.returnResource(book), is(ReturnStatus.FAILURE));
    }

    @Test
    public void shouldReturnFailureStatusOnReturnIfNotExistent() {
        assertThat(bibliotecaBookShelf.returnResource("The Great Gatsby"), is(ReturnStatus.FAILURE));
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
        bibliotecaBookShelf.checkoutResource(borrower, book);
        bibliotecaBookShelf.checkoutResource(borrower, "Rainbirds");
        assertThat(bibliotecaBookShelf.getAllCheckedOutResources(), is(listOfAllCheckedOutBooks));
    }

    @Test
    public void shouldSeeAllCheckedOutBooksOfUser() {
        bibliotecaBookShelf.checkoutResource(borrower, book);
        bibliotecaBookShelf.checkoutResource(borrower, "Rainbirds");
        assertThat(bibliotecaBookShelf.getAllCheckedOutResourcesOfUser(borrower), is(listOfAllCheckedOutBooks));
    }
}
