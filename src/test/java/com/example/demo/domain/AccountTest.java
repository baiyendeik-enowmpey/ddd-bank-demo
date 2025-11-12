package com.example.demo.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositIncreasesBalance() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false);
        a.deposit(BigDecimal.valueOf(50));
        assertEquals(0, BigDecimal.valueOf(150).compareTo(a.getBalance()));
    }

    @Test
    void withdrawWithSufficientFunds() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false);
        a.withdraw(BigDecimal.valueOf(70));
        assertEquals(0, BigDecimal.valueOf(30).compareTo(a.getBalance()));
    }

    @Test
    void withdrawThrowsWhenInsufficientAndNoOverdraft() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false);
        assertThrows(IllegalStateException.class, () -> a.withdraw(BigDecimal.valueOf(200)));
    }
}
