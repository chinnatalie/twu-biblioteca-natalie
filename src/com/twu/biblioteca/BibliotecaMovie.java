package com.twu.biblioteca;

public class BibliotecaMovie extends BibliotecaResource {
    private String director;
    private String rating;

    public BibliotecaMovie(String name, String publishedYear, String director, String rating) {
        super(name, publishedYear);
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        String details = this.getName() + " | " + this.getPublishedYear() + " | " + director + " | " + rating;
        return details;
    }
}
