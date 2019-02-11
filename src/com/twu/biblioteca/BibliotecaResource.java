package com.twu.biblioteca;

abstract class BibliotecaResource {

    private final String name;
    private final String publishedYear;

    public BibliotecaResource(String name, String publishedYear) {
        this.name = name;
        this.publishedYear = publishedYear;
    }

    String getName() {
        return name;
    }

    String getPublishedYear() {
        return publishedYear;
    }
}
