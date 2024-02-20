package com.blueharvest.bankaccount.service;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.dto.CreateAccountDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountDto openAccount(CreateAccountDto createAccountDto);
}
