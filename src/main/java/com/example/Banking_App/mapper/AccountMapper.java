package com.example.Banking_App.mapper;

import com.example.Banking_App.dto.AccountDto;
import com.example.Banking_App.entity.Account;

public class AccountMapper {

    public static AccountDto maptoAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }

    public static Account maptoAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    }
}
