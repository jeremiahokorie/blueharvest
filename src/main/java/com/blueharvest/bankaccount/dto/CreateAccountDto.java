package com.blueharvest.bankaccount.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountDto {
    private Long customerId;
    private BigDecimal initialCredit;

    public CreateAccountDto(Long customerId, BigDecimal initialCredit) {
    }
}
