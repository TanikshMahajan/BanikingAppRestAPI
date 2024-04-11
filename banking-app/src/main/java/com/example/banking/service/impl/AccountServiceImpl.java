package com.example.banking.service.impl;

import com.example.banking.entity.Account;
import com.example.banking.repository.AccountRepository;
import com.example.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(int id) {

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist " + id));

        return account;
    }

    @Override
    public Account deposit(int id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist " + id));

        double total = account.getBalance() + amount;
        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    @Override
    public Account withdraw(int id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist " + id));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(int id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist " + id));

        accountRepository.deleteById(id);
    }
}
