package com.twu.biblioteca;

public class BibliotecaAccount {
    private String libraryNumber;
    private String password;
    
    BibliotecaAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean authenticate(String password) {
        if (password.equals(this.password))
            return true;
        else
            return false;
    }

    public boolean hasNumber(String libraryNumber) {
        if (libraryNumber.equals(this.libraryNumber))
            return true;
        else
            return false;
    }
}
