package com.blueharvest.bankaccount.repository;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.dto.CreateAccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {



    private AccountRepository accountOpeningTest;

    @Test
    void findByOwner() {
        //Given


        //when

        //then
    }

    @Test
    void setAccountOpeningTest(){
        //Given
        Long customerId = 1L;
        BigDecimal  initialCredit = BigDecimal.valueOf(50);

        CreateAccountDto accountDto = new CreateAccountDto(
                customerId,
                initialCredit
        );
    }



}