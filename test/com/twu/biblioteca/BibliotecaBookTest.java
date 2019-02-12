package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaBookTest {
    private BibliotecaBook book;
    private String name = "Rainbirds";
    private String author = "Clarissa Goenawan";
    private String publishedYear = "2018";

    private String borrower = "123-4567";

    @Before
    public void initializeBook() {
        book = new BibliotecaBook(name, author, publishedYear);
    }

    @Test
    public void shouldReturnName() {
        assertThat(book.getName(), is(name));
    }

    @Test
    public void shouldReturnDetails() {
        String details = book.getDetails();
        assertThat(details, containsString(name));
        assertThat(details, containsString(author));
        assertThat(details, containsString(publishedYear));
    }

    @Test
    public void shouldReturnAvailability() {
        assertThat(book.getAvailability(), is(AvailabilityStatus.AVAILABLE));
    }

    @Test
    public void shouldReturnCheckedOut() {
        book.checkOut("123-4567");
        assertThat(book.getAvailability(), is(AvailabilityStatus.CHECKEDOUT));
    }

    @Test
    public void shouldReturnAvailableIfReturned() {
        book.checkOut(borrower);
        book.checkIn();
        assertThat(book.getAvailability(), is(AvailabilityStatus.AVAILABLE));
    }

    @Test
    public void shouldReturnTrueIfAvailable() {
        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void shouldReturnFalseIfUnavailable() {
        book.checkOut(borrower);
        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void shouldReturnTrueIfCheckedOut() {
        book.checkOut(borrower);
        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldReturnUserAfterCheckOut() {
        book.checkOut(borrower);
        assertThat(book.getBorrower(), is(Optional.ofNullable("123-4567")));
    }

    @Test
    public void shouldReturnEmptyAfterCheckIn() {
        book.checkOut(borrower);
        book.checkIn();
        assertThat(book.getBorrower(), is(Optional.empty()));
    }
}
