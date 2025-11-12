package com.example.demo.presentation;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.TransferMoneyService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final TransferMoneyService transferService;

    public AccountController(TransferMoneyService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public Map<String, String> transfer(@RequestParam Long from,
                                        @RequestParam Long to,
                                        @RequestParam java.math.BigDecimal amount) {
        transferService.transfer(from, to, amount);
        return Map.of("status", "ok");
    }
}
