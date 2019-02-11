package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaAccountManager {
    ArrayList<BibliotecaAccount> accounts;

    BibliotecaAccountManager() {
        accounts = new ArrayList<>();
        accounts.add(new BibliotecaAccount("987-6543", "1234"));
        accounts.add(new BibliotecaAccount("123-4567", "password123"));
        accounts.add(new BibliotecaAccount("876-5432", "helloworld"));
        accounts.add(new BibliotecaAccount("234-5678", "sushi"));
        accounts.add(new BibliotecaAccount("765-4321", "bullfrog"));
    }

    public boolean loginUser(String libraryNumber, String password) {
        for (BibliotecaAccount account: accounts) {
            if (account.authenticate(password))
                return true;
        }
        return false;
    }
}
