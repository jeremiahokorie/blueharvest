package com.blueharvest.bankaccount.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AccountDto {
    private Long accountId;

    private String accountNumber;

    private BigDecimal balance;

    private String type;

    private Date createdAt;

    private Long ownerId;

    private List<TransactionDto> transactions = new ArrayList<>();
}
