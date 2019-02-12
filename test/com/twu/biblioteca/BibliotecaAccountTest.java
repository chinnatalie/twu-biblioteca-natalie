package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaAccountTest {

    private BibliotecaAccount account;

    private final String libraryNumber = "123-4567";
    private final String password = "password123";
    private final String name = "Tan Ting Gi";
    private final String email = "tinggi.tan@thoughtworks.com";
    private final String phoneNumber = "+65 9876 5432";
    private final String accountDetails = "Library number: 123-4567\n" +
            "Name: Tan Ting Gi\n" +
            "Email: tinggi.tan@thoughtworks.com\n" +
            "Phone number: +65 9876 5432\n";

    @Before
    public void initializeAccount() {
        account = new BibliotecaAccount(libraryNumber, password, name, email, phoneNumber);
    }

    @Test
    public void shouldReturnTrueIfCorrectPassword() {
        assertThat(account.authenticate(password), is(true));
    }

    @Test
    public void shouldReturnFalseIfWrongPassword() {
        assertThat(account.authenticate("pazzwork321"), is(false));
    }

    @Test
    public void shouldReturnAccountDetails() {
        assertThat(account.getDetails(), is(accountDetails));
    }
}
