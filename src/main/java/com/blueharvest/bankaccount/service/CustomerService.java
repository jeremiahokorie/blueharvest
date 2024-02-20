package com.blueharvest.bankaccount.service;

import com.blueharvest.bankaccount.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDto getCustomerInfo(Long customerId);
}
