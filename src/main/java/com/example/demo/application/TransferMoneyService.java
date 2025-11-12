package com.example.demo.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.AccountRepository;
import com.example.demo.domain.Account;

import java.math.BigDecimal;

@Service
public class TransferMoneyService {

    private final AccountRepository accounts;

    public TransferMoneyService(AccountRepository accounts) {
        this.accounts = accounts;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = accounts.findById(fromId).orElseThrow(() -> new IllegalArgumentException("Source account not found"));
        Account to = accounts.findById(toId).orElseThrow(() -> new IllegalArgumentException("Target account not found"));
        from.withdraw(amount);
        to.deposit(amount);
        accounts.save(from);
        accounts.save(to);
    }
}
