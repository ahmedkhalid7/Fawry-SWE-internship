package org.example.account;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AccountManagerImplTest {
    private AccountManager accountManager;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        accountManager = new AccountManagerImpl();
        customer = new Customer();
        customer.setBalance(1000);
        customer.setCreditAllowed(true);
        customer.setMaxCredit(1000);
        customer.setVip(false);
    }

    @Test
    public void testDeposit() {
        accountManager.deposit(customer, 500);
        assertThat(customer.getBalance()).isEqualTo(1000 + 500);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        String result = accountManager.withdraw(customer, 500);
        assertThat(result).isEqualTo("success");
        assertThat(customer.getBalance()).isEqualTo(1000 - 500);
    }

    @Test
    public void testWithdrawInsufficientBalanceWithoutCredit() {
        customer.setCreditAllowed(false);
        String result = accountManager.withdraw(customer, 2000);
        assertThat(result).isEqualTo("insufficient account balance");
        assertThat(customer.getBalance()).isEqualTo(1000);
    }

    @Test
    public void testWithdrawInsufficientBalanceWithCredit() {
        String result = accountManager.withdraw(customer, 2000);
        assertThat(result).isEqualTo("success");
        assertThat(customer.getBalance()).isEqualTo(-1000);
    }

    @Test
    public void testWithdrawExceedMaxCreditVIP() {
        customer.setVip(true);
        String result = accountManager.withdraw(customer, 1500);
        assertThat(result).isEqualTo("success");
        assertThat(customer.getBalance()).isEqualTo(-500);
    }

    @Test
    public void testWithdrawZeroAmount() {
        String result = accountManager.withdraw(customer, 0);
        assertThat(result).isEqualTo("success");
        assertThat(customer.getBalance()).isEqualTo(1000);
    }

    @Test
    public void testDepositNegativeAmount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> accountManager.deposit(customer, -500))
                .withMessage("Invalid deposit amount: " + -500);
        assertThat(customer.getBalance()).isEqualTo(1000);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> accountManager.withdraw(customer, -500))
                .withMessage("Invalid withdrawal amount: " + -500);
        assertThat(customer.getBalance()).isEqualTo(1000);
    }
}