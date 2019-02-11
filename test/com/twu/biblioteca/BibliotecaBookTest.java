package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

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
}
