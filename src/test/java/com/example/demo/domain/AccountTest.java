package com.example.demo.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

	private BigDecimal OVERDRAFT_LIMIT = BigDecimal.valueOf(100);

    @Test
    void depositIncreasesBalance() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false, BigDecimal.ZERO);
        a.deposit(BigDecimal.valueOf(50));
        assertEquals(0, BigDecimal.valueOf(150).compareTo(a.getBalance()));
    }

    @Test
    void withdrawWithSufficientFunds() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false, BigDecimal.ZERO);
        a.withdraw(BigDecimal.valueOf(70));
        assertEquals(0, BigDecimal.valueOf(30).compareTo(a.getBalance()));
    }

    @Test
    void withdrawThrowsWhenInsufficientAndNoOverdraft() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), false, BigDecimal.ZERO);
        assertThrows(IllegalStateException.class, () -> a.withdraw(BigDecimal.valueOf(200)));
    }

    @Test
    void withdrawThrowsWhenOverdraftLimitExceeds() {
        Account a = new Account(null, "T", BigDecimal.valueOf(100), true, OVERDRAFT_LIMIT);
        assertThrows(IllegalStateException.class, () -> a.withdraw(BigDecimal.valueOf(250)));
    }
}
