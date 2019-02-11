package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BibliotecaAccountManagerTest {
    private BibliotecaAccountManager accountManager;

    @Before
    public void initializeAccountManager() {
        accountManager = new BibliotecaAccountManager();
    }

    @Test
    public void shouldReturnTrueIfCorrectNumberAndCoreectPassword() {
        assertThat(accountManager.loginUser("123-4567", "password123"), is(true));
    }
}