package com.twu.biblioteca;

public class BibliotecaBook extends BibliotecaResource {

    private final String author;

    BibliotecaBook (String name, String author, String publishedYear) {
        super(name, publishedYear);
        this.author = author;
    }

    public String getDetails() {
        String details = this.getName() + " | " + author + " | " + this.getPublishedYear();
        return details;
    }
}
