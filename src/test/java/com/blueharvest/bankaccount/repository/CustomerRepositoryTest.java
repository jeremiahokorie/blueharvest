package com.blueharvest.bankaccount.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepositoryTest;

    @AfterEach
    void tearDown() {
        customerRepositoryTest.deleteAll();
    }
    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldCheckIfCustomerWithIdDoesNotExists(){
        //given
        Long customerId = 10L;
        //when
        boolean expected = customerRepositoryTest.existsById(customerId);
        //then
        assertThat(expected).isFalse();
    }

    @Test
    @Disabled
    void shouldCheckIfCustomerWithIDExist(){
        Long customerId = 1L;
        boolean expected = customerRepositoryTest.existsById(customerId);
        assertThat(expected).isTrue();
    }




}