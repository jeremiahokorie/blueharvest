package com.blueharvest.bankaccount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    private String type;

    private Date createdAt;

    @ManyToOne
    private Customer owner;

    private Long customerId;

    public Account(String accountNumber, BigDecimal balance, String type, Date createdAt, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.createdAt = createdAt;
        this.owner = owner;
    }

    public Account() {

    }
}
