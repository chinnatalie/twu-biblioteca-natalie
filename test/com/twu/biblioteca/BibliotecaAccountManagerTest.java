package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaAccountManagerTest {

    private BibliotecaAccountManager accountManager;

    private final String libraryNumber = "123-4567";
    private final String password = "password123";
    private final String accountDetails = "Library number: 123-4567\n" +
            "Name: Tan Ting Gi\n" +
            "Email: tinggi.tan@thoughtworks.com\n" +
            "Phone number: +65 9876 5432\n";


    @Before
    public void initializeAccountManager() {
        accountManager = new BibliotecaAccountManager();
    }

    @Test
    public void shouldReturnTrueIfCorrectNumberAndCoreectPassword() {
        assertThat(accountManager.loginUser(libraryNumber, password), is(true));
    }

    @Test
    public void shouldReturnFalseIfWrongPassword() {
        assertThat(accountManager.loginUser(libraryNumber, "1234"), is(false));
    }

    @Test
    public void shouldReturnLoggedInUser() {
        accountManager.loginUser(libraryNumber, password);
        assertThat(accountManager.getLoggedInUser(), is(libraryNumber));
    }

    @Test
    public void shouldReturnLoggedInUserDetails() {
        accountManager.loginUser(libraryNumber, password);
        assertThat(accountManager.getLoggedInUserDetails(), is(accountDetails));
    }
}