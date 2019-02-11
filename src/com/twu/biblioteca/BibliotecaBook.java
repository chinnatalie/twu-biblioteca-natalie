package com.twu.biblioteca;

public class BibliotecaBook {
    private enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}

    private final String name;
    private final String author;
    private final String publishedYear;
    private AvailabilityStatus availability;

    BibliotecaBook (String name, String author, String publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.availability = AvailabilityStatus.AVAILABLE;
    }

    public String getName() {
        return this.name;
    }
}
