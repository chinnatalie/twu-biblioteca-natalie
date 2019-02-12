package com.twu.biblioteca;

public class BibliotecaAccount {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    
    BibliotecaAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    BibliotecaAccount(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean authenticate(String password) {
        if (password.equals(this.password))
            return true;
        else
            return false;
    }

    public boolean hasCorrectCredentials(String libraryNumber, String password) {
        if (this.libraryNumber.equals(libraryNumber) && this.password.equals(password))
            return true;
        else
            return false;
    }

    public String getDetails() {
        String details = "";
        details += "Library number: " + libraryNumber + "\n";
        details += "Name: " + name + "\n";
        details += "Email: " + email + "\n";
        details += "Phone number: " + phoneNumber + "\n";
        return details;
    }
}
