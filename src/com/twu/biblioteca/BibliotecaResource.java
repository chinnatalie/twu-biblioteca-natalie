package com.twu.biblioteca;

enum AvailabilityStatus {AVAILABLE, CHECKEDOUT}

abstract class BibliotecaResource {

    private final String name;
    private final String publishedYear;
    private AvailabilityStatus availability;

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

    public void checkOut() {
        this.availability = AvailabilityStatus.CHECKEDOUT;
    }

    public void isReturned() {
        this.availability = AvailabilityStatus.AVAILABLE;
    }
}
