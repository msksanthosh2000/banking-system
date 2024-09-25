package com.example.Banking_App.service.impl;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.entity.Account;
import com.example.Banking_App.mapper.AccountMapper;
import com.example.Banking_App.repository.AccountRepository;
import com.example.Banking_App.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = AccountMapper.maptoAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account Not found for Id:" + id)
        );

        AccountDto accountDto = AccountMapper.maptoAccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account Not found for Id:" + id)
        );

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account Not found for Id:" + id)
        );
        if (amount > account.getBalance()) {
            throw new RuntimeException("Insufficient Amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {

        List<Account> accounts = accountRepository.findAll();

        List<AccountDto> allAccountDto = accounts.stream().map(AccountMapper::maptoAccountDto).toList();
        return allAccountDto;
    }

    @Override
    public String deleteAccountById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account Not found for Id:" + id)
        );
        accountRepository.deleteById(id);
        return "Account Successfully Deleted";
    }
}
