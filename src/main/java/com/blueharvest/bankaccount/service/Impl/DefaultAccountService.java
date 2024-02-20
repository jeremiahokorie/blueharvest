package com.blueharvest.bankaccount.service.Impl;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.dto.CreateAccountDto;
import com.blueharvest.bankaccount.dto.TransactionDto;
import com.blueharvest.bankaccount.entity.Account;
import com.blueharvest.bankaccount.entity.Customer;
import com.blueharvest.bankaccount.entity.Transaction;
import com.blueharvest.bankaccount.repository.AccountRepository;
import com.blueharvest.bankaccount.repository.CustomerRepository;
import com.blueharvest.bankaccount.repository.TransactionRepository;
import com.blueharvest.bankaccount.service.AccountService;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Override
    public AccountDto openAccount(CreateAccountDto createAccountDto) {
        Long customerId = createAccountDto.getCustomerId();
        BigDecimal initialCredit = createAccountDto.getInitialCredit();

        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setEmail(generateRandomEmail());
            customer.setName(generateRandomName());
            customer.setSurname(generateRandomSurname());
            customer.setPhone(generateRandomPhone());
            customerRepository.save(customer);

            // Create a new account entity
            Account account = new Account();
            account.setCustomerId(customerId);
            account.setBalance(initialCredit);
            account.setOwner(customer);
            account.setAccountNumber(generatedAccountNumber());
            account.setCreatedAt(new Date());
            account.setType("current");

            accountRepository.save(account);
            AccountDto accountDTO = new AccountDto();

            // If initialCredit is not 0, create a transaction
            if (initialCredit.compareTo(BigDecimal.ZERO) > 0) {
                Transaction transaction = new Transaction();
                transaction.setAccount(account);
                transaction.setAmount(initialCredit);
                transaction.setCreatedAt(new Date());
                transaction.setDescription("Initial credit");
                // Save the transaction to the database
                transactionRepository.save(transaction);

                accountDTO.setTransactions(Collections.singletonList(TransactionDto.builder()
                        .amount(transaction.getAmount())
                        .balance(transaction.getBalance())
                        .transactionId(transaction.getId())
                        .createdAt(transaction.getCreatedAt())
                        .description(transaction.getDescription())

                        .build()));
            }

            // Create AccountDTO from saved account
            accountDTO.setAccountId(account.getId());
            accountDTO.setOwnerId(account.getOwner().getId());
            accountDTO.setBalance(account.getBalance());
            accountDTO.setAccountNumber(account.getAccountNumber());
            accountDTO.setCreatedAt(account.getCreatedAt());
            accountDTO.setType(account.getType());
            return accountDTO;
        }

        return null;
    }
private static String generatedAccountNumber(){
    int accountNo = ThreadLocalRandom.current().nextInt();
    return "ACC-"+ accountNo;
}




    // Method to generate a random email
    private static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        Random random = new Random();
        String name = generateRandomName() + generateRandomSurname();
        return name.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    // Method to generate a random name
    private static String generateRandomName() {
        String[] names = {"John", "Emily", "Michael", "Jessica", "Daniel", "Sophia", "David", "Emma", "James", "Olivia"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    // Method to generate a random surname
    private static String generateRandomSurname() {
        String[] surnames = {"Smith", "Johnson", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Taylor", "Wilson"};
        Random random = new Random();
        return surnames[random.nextInt(surnames.length)];
    }

    // Method to generate a random phone number
    private static String generateRandomPhone() {
        Random random = new Random();
        StringBuilder phone = new StringBuilder("+");
        for (int i = 0; i < 10; i++) {
            phone.append(random.nextInt(10));
            if (i == 2 || i == 5) {
                phone.append("-");
            }
        }
        return phone.toString();
    }
}
