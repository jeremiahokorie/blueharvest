package com.blueharvest.bankaccount.repository;

import com.blueharvest.bankaccount.entity.Account;
import com.blueharvest.bankaccount.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountIdIn(List<Long> collect);

    List<Transaction> findByAccount(Account id);
}
