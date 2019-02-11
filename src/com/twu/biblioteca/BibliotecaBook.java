package com.twu.biblioteca;

enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}

public class BibliotecaBook extends BibliotecaResource {

    private final String author;
    private AvailabilityStatus availability;

    BibliotecaBook (String name, String author, String publishedYear) {
        super(name, publishedYear);
        this.author = author;
        this.availability = AvailabilityStatus.AVAILABLE;
    }

    public String getDetails() {
        String details = this.getName() + " | " + author + " | " + this.getPublishedYear();
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

    public boolean isAvailable() {
        if (this.availability == AvailabilityStatus.AVAILABLE)
            return true;
        else
            return false;
    }

    public boolean isCheckedOut() {
        if (this.availability == AvailabilityStatus.CHECKEDOUT)
            return true;
        else
            return false;
    }
}
