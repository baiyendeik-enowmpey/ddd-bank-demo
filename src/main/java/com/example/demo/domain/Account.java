package com.example.demo.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;

    private BigDecimal balance;

    private boolean overdraftAllowed;

    public void deposit(java.math.BigDecimal amount) {
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.balance = this.balance.add(amount);
    }

    public void withdraw(java.math.BigDecimal amount) {
        if (amount.signum() <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (!overdraftAllowed && balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds and overdraft not allowed");
        }
        this.balance = this.balance.subtract(amount);
    }
}
