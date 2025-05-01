package com.BankingManagementSystem.controller;

import com.BankingManagementSystem.dto.AccountDto;
import com.BankingManagementSystem.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

//    add account rest api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody @Valid AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
//    get account details
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccountById( @PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/deposit")
    public  ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request ){
        Double amount = request.get("amount");
        AccountDto accountDto =  accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
        List<AccountDto> accountDto = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDto);
    }

}
