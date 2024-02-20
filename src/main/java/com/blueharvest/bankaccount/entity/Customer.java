package com.blueharvest.bankaccount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String surname;

    private String email;

    private  String phone;

    public Customer(Long customerId, String name, String surname, String email, String phone) {
        this.id = customerId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {

    }
}
