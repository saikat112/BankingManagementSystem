package com.BankingManagementSystem.service.impl;

import com.BankingManagementSystem.dto.AccountDto;
import com.BankingManagementSystem.entity.Account;
import com.BankingManagementSystem.mapper.AccountMapper;
import com.BankingManagementSystem.repository.AccountRepository;
import com.BankingManagementSystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not exist"));

        return AccountMapper.mapToAccountDto(account);
    }
    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
        Double totalBalance = account.getBalance() + amount;
        account.setBalance(totalBalance);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount) ;
    }
    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
       if(account.getBalance() < amount){
           throw new RuntimeException("Insuffcient Balance");
       }
       Double totalBalance = account.getBalance() - amount;
       account.setBalance(totalBalance);
       Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }
}
