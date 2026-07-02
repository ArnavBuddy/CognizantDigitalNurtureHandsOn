package com.bank.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Demonstrates the Arrange-Act-Assert (AAA) pattern together with a test
 * fixture that is created in @Before (setup) and released in @After
 * (teardown) before/after every test method.
 */
public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Test fixture: a fresh account is created before every test
        account = new BankAccount(1000.0);
        System.out.println("setUp: created account with balance " + account.getBalance());
    }

    @After
    public void tearDown() {
        // Teardown: release the fixture after every test
        account = null;
        System.out.println("tearDown: account reference cleared");
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 500.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 300.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientBalanceThrowsException() {
        // Arrange
        double withdrawAmount = 5000.0;

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> account.withdraw(withdrawAmount));
    }
}
