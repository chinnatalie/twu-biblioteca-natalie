package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaAccountTest {

    private BibliotecaAccount account;

    @Before
    public void initializeAccount() {
        account = new BibliotecaAccount("123-4567", "password123");
    }

    @Test
    public void shouldReturnTrueIfCorrectPassword() {
        assertThat(account.authenticate("password123"), is(true));
    }
}
