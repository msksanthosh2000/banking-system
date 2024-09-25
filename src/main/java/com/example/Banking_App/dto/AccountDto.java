package com.example.Banking_App.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;
}
