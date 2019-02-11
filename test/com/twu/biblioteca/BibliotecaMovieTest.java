package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaMovieTest {

    private BibliotecaMovie movie;

    private String name = "Ilo Ilo";

    @Before
    public void initializeMovie() {
        movie = new BibliotecaMovie(name);
    }

    @Test
    public void shouldReturnMovieName() {
        assertThat(movie.getName(), is(name));
    }
}
