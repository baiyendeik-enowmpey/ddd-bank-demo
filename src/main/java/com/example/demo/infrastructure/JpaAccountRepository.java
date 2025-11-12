package com.example.demo.infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountRepository;

@Repository
public class JpaAccountRepository implements AccountRepository {

    private final SpringDataAccountJpa jpa;

    public JpaAccountRepository(SpringDataAccountJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Account save(Account account) {
        return jpa.save(account);
    }
}
