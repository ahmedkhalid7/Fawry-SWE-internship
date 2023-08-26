package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreTest {
    @Mock
    private AccountManager accountManager;

    @InjectMocks
    private MyStore myStore;

    private Product product;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        product = new Product("Test Product", 100, 2);
        customer = new Customer("Ahmed Khalid", 500, true, 1000, false);
    }

    @Test
    public void testSuccessfulPurchase() {
        when(accountManager.withdraw(customer, product.getPrice())).thenReturn("success");

        myStore.buy(product, customer);

        verify(accountManager, times(1)).withdraw(customer, product.getPrice());
        verifyNoMoreInteractions(accountManager);
        assertEquals(1, product.getQuantity());
    }

    @Test
    public void testOutOfStock() {
        product.setQuantity(0);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> myStore.buy(product, customer));
        assertEquals("Product out of stock", exception.getMessage());

        verifyNoInteractions(accountManager);
    }

    @Test
    public void testPaymentFailure() {
        product.setPrice(600);
        when(accountManager.withdraw(customer, product.getPrice())).thenReturn("insufficient account balance");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> myStore.buy(product, customer));
        assertEquals("Payment failure: insufficient account balance", exception.getMessage());

        verify(accountManager, times(1)).withdraw(customer, product.getPrice());
        verifyNoMoreInteractions(accountManager);
        assertEquals(2, product.getQuantity());
    }

    @Test
    public void testWithdrawalMaximumCreditExceeded() {
        product.setPrice(3000);
        when(accountManager.withdraw(customer, product.getPrice())).thenReturn("maximum credit exceeded");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> myStore.buy(product, customer));
        assertEquals("Payment failure: maximum credit exceeded", exception.getMessage());

        verify(accountManager).withdraw(customer, product.getPrice());
        assertEquals(2, product.getQuantity());
    }
}