package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

public class BibliotecaMovieTest {

    private BibliotecaMovie movie;

    private String name = "Ilo Ilo";
    private String publishedYear = "2013";
    private String director = "Anthony Chen";
    private String rating = "7.3";

    @Before
    public void initializeMovie() {
        movie = new BibliotecaMovie(name, publishedYear, director, rating);
    }

    @Test
    public void shouldReturnMovieName() {
        assertThat(movie.getName(), is(name));
    }

    @Test
    public void shouldReturnMovieDetails() {
        String details = movie.getDetails();
        assertThat(details, containsString(name));
        assertThat(details, containsString(publishedYear));
        assertThat(details, containsString(director));
        assertThat(details, containsString(rating));
    }
}