package com.BankingManagementSystem.service.impl;

import com.BankingManagementSystem.dto.AccountDto;
import com.BankingManagementSystem.entity.Account;
import com.BankingManagementSystem.mapper.AccountMapper;
import com.BankingManagementSystem.repository.AccountRepository;
import com.BankingManagementSystem.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }
}
