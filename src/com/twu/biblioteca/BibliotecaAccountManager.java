package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Optional;

public class BibliotecaAccountManager {

    private ArrayList<BibliotecaAccount> accounts;
    private Optional<String> loggedInUser;

    BibliotecaAccountManager() {
        accounts = new ArrayList<>();
        accounts.add(new BibliotecaAccount("987-6543", "1234", "Ho Kam Bing", "kambing.ho@thoughtworks.com", "+65 8765 4321"));
        accounts.add(new BibliotecaAccount("123-4567", "password123", "Tan Ting Gi", "tinggi.tan@thoughtworks.com", "+65 9876 5432"));
        accounts.add(new BibliotecaAccount("876-5432", "helloworld", "Lee Na Si", "nasi.lee@thoughtworks.com", "+65 9123 3219"));
        accounts.add(new BibliotecaAccount("234-5678", "sushi", "Kuan Ah Yam", "ahyam.kuan@thoughtworks.com", "+65 8000 0000"));
        accounts.add(new BibliotecaAccount("765-4321", "bullfrog", "Goh Ru Mah", "rumah.goh@thoughtworks.com", "+65 6789 1234"));
    }

    public boolean loginUser(String libraryNumber, String password) {
        for (BibliotecaAccount account : accounts) {
            if (account.hasCorrectCredentials(libraryNumber, password)) {
                loggedInUser = Optional.of(libraryNumber);
                return true;
            }
        }
        return false;
    }

    public String getLoggedInUser() {
        return loggedInUser.get();
    }

    public String getLoggedInUserDetails() {
        for (BibliotecaAccount account : accounts) {
            if (account.hasLibraryNumber(loggedInUser.get())) {
                return account.getDetails();
            }
        }
        return "No info found";
    }
}
