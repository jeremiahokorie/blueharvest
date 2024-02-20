package com.blueharvest.bankaccount.util;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.entity.Account;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class converterConfig {

    private ModelMapper modelMapper;

    public AccountDto fromAccount(Account account){
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return accountDto;
    }
}
