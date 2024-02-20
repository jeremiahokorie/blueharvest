package com.blueharvest.bankaccount.service.Impl;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.dto.CustomerDto;
import com.blueharvest.bankaccount.dto.TransactionDto;
import com.blueharvest.bankaccount.entity.Account;
import com.blueharvest.bankaccount.entity.Customer;
import com.blueharvest.bankaccount.entity.Transaction;
import com.blueharvest.bankaccount.repository.AccountRepository;
import com.blueharvest.bankaccount.repository.CustomerRepository;
import com.blueharvest.bankaccount.repository.TransactionRepository;
import com.blueharvest.bankaccount.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    @Override
    public CustomerDto getCustomerInfo(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        List<Account> accounts = accountRepository.findByOwner(customer);
        // Retrieve transactions associated with the customer's accounts

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.get().getId());
        customerDto.setName(customer.get().getName());
        customerDto.setPhone(customer.get().getPhone());
        customerDto.setSurname(customer.get().getSurname());
        customerDto.setEmail(customer.get().getEmail());

        List<AccountDto> accountInfoDTOs = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto accountInfoDTO = new AccountDto();
            accountInfoDTO.setAccountId(account.getId());
            accountInfoDTO.setBalance(account.getBalance());
            accountInfoDTO.setOwnerId(account.getOwner().getId());
            accountInfoDTO.setAccountNumber(account.getAccountNumber());
            accountInfoDTO.setCreatedAt(account.getCreatedAt());
            accountInfoDTO.setType(account.getType());

            // Set transactions for each account
            List<Transaction> accountTransactions = transactionRepository.findByAccount(account);

            List<TransactionDto> transactionDtos = new ArrayList<>();
            accountTransactions.forEach(transaction ->
                    transactionDtos.add(TransactionDto.builder()
                            .amount(transaction.getAmount())
                            .balance(transaction.getBalance())
                            .transactionId(transaction.getId())
                            .createdAt(transaction.getCreatedAt())
                            .description(transaction.getDescription())
                            .build()));
            accountInfoDTO.setTransactions(transactionDtos);
            accountInfoDTOs.add(accountInfoDTO);

        }
        customerDto.setAccounts(accountInfoDTOs);
        return customerDto;
    }
}
