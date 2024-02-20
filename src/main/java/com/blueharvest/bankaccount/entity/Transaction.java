package com.blueharvest.bankaccount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  BigDecimal amount;

    private  BigDecimal balance;

    private Date createdAt;

    private  String description;

    @ManyToOne
    private  Account account;

    public Transaction(BigDecimal amount, BigDecimal balance, Date createdAt, String description, Account account) {
        this.amount = amount;
        this.balance = balance;
        this.createdAt = createdAt;
        this.description = description;
        this.account = account;
    }

    public Transaction() {

    }
}
