package com.example.Banking_App.service;

import com.example.Banking_App.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto addAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccount();

    String deleteAccountById(Long id);
}
