package com.blueharvest.bankaccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class TransactionDto {
    private Long transactionId;

    private BigDecimal amount;

    private BigDecimal balance;

    private Date createdAt;

    private String description;
}
