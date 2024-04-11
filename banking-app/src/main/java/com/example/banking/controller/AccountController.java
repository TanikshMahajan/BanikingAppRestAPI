package com.example.banking.controller;

import com.example.banking.entity.Account;
import com.example.banking.service.AccountService;
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
        this.accountService = accountService;
    }

    // Add Account REST API
    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {

        account.setId(0);

        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    // Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Account account = accountService.getAccountById(id);

//        return new ResponseEntity<>(account, HttpStatus.OK);
        return ResponseEntity.ok(account);
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable int id, @RequestBody Map<String, Double> request) {

        Double amount = request.get("amount");
        Account account = accountService.deposit(id, amount);

        return ResponseEntity.ok(account);
    }

    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable int id, @RequestBody Map<String, Double> request) {

        Double amount = request.get("amount");
        Account account = accountService.withdraw(id, amount);

        return ResponseEntity.ok(account);
    }

    // Get all Accounts REST API
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    // Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id){
        accountService.deleteAccount(id);

        return ResponseEntity.ok("Account is deleted successfully!");
    }
}
