package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaBookTest {
    private BibliotecaBook book;
    private String name = "Rainbirds";
    private String author = "Clarissa Goenawan";
    private String publishedYear = "2018";

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
}
