package com.twu.biblioteca;

enum Membership {MEMBER, LIBRARIAN}

public class BibliotecaAccount {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Membership membership = Membership.MEMBER;

    BibliotecaAccount(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    BibliotecaAccount(String libraryNumber, String password, String name, String email, String phoneNumber, boolean isLibrarian) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membership = Membership.LIBRARIAN;
    }

    public boolean authenticate(String password) {
        if (password.equals(this.password))
            return true;
        else
            return false;
    }

    public boolean hasCorrectCredentials(String libraryNumber, String password) {
        return this.libraryNumber.equals(libraryNumber) && this.password.equals(password);
    }

    public String getDetails() {
        String details = "";
        details += "Library number: " + libraryNumber + "\n";
        details += "Name: " + name + "\n";
        details += "Email: " + email + "\n";
        details += "Phone number: " + phoneNumber + "\n";
        return details;
    }

    public boolean hasLibraryNumber(String libraryNumber) {
        return this.libraryNumber.equals(libraryNumber);
    }

    public boolean isLibrarian() {
        return membership.equals(Membership.LIBRARIAN);
    }
}
