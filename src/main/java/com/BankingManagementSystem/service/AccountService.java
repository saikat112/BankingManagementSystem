package com.BankingManagementSystem.service;

import com.BankingManagementSystem.dto.AccountDto;

import java.util.List;

public interface AccountService {
    abstract AccountDto createAccount(AccountDto account);
    abstract AccountDto getAccountById (Long id);
    abstract AccountDto deposit(Long id, double amount );
    abstract AccountDto withdraw(Long id,double amount );
    List<AccountDto> getAllAccounts();
}

