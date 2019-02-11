package com.twu.biblioteca;

enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}

public class BibliotecaBook {

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

    public String getDetails() {
        String details = name + " | " + author + " | " + publishedYear;
        return details;
    }

    public AvailabilityStatus getAvailability() {
        return this.availability;
    }

    public void checkOut() {
        this.availability = AvailabilityStatus.CHECKEDOUT;
    }

    public void isReturned() {
        this.availability = AvailabilityStatus.AVAILABLE;
    }
}
