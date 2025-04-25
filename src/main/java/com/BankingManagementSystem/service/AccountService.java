package com.BankingManagementSystem.service;

import com.BankingManagementSystem.dto.AccountDto;

public interface AccountService {
    abstract AccountDto createAccount(AccountDto account);
}
