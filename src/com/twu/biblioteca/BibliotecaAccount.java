package com.twu.biblioteca;

public class BibliotecaAccount {
    private String libraryNumber;
    private String password;
    
    BibliotecaAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean authenticate(String password123) {
        if (password123 == this.password)
            return true;
        return true;
    }
}
