package com.twu.biblioteca;

import java.util.Optional;

enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}

abstract class BibliotecaResource {

    private final String name;
    private final String publishedYear;
    private AvailabilityStatus availability;
    private Optional<String> borrower;

    public BibliotecaResource(String name, String publishedYear) {
        this.name = name;
        this.publishedYear = publishedYear;
        this.availability = AvailabilityStatus.AVAILABLE;
    }

    String getName() {
        return name;
    }

    String getPublishedYear() {
        return publishedYear;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }
    
    abstract String getDetails();

    public String getLoan() {
        return name + " | " + borrower.get();
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

    public boolean isCheckedOutBy(String user) {
        if (this.isCheckedOut() && isBorrowedBy(user))
            return true;
        else
            return false;
    }

    public void checkOut(String borrower) {
        this.availability = AvailabilityStatus.CHECKEDOUT;
        this.borrower = Optional.ofNullable(borrower);
    }

    public void checkIn() {
        this.availability = AvailabilityStatus.AVAILABLE;
        this.borrower = Optional.empty();
    }

    public Optional<String> getBorrower() {
        return borrower;
    }

    public boolean hasName(String name) {
        if (this.name.equals(name))
            return true;
        else
            return false;
    }

    private boolean isBorrowedBy(String user) {
        if (borrower.get().equals(user))
            return true;
        else
            return false;
    }
}
