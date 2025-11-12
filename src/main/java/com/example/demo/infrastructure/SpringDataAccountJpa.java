package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Account;

public interface SpringDataAccountJpa extends JpaRepository<Account, Long> {}