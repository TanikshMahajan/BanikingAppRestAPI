package com.example.banking.service;

import com.example.banking.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(int id);

    Account deposit(int id, double amount);

    Account withdraw(int id, double amount);

    List<Account> getAllAccounts();

    void deleteAccount(int id);
}
