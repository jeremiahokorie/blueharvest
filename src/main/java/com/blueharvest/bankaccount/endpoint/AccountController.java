package com.blueharvest.bankaccount.endpoint;

import com.blueharvest.bankaccount.dto.AccountDto;
import com.blueharvest.bankaccount.dto.CreateAccountDto;
import com.blueharvest.bankaccount.service.AccountService;
import com.blueharvest.bankaccount.util.ApiResponse;
import com.blueharvest.bankaccount.util.AppConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstant.BASE_URL + "account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @PostMapping("/create")
    public ApiResponse<AccountDto> createAccount(@RequestBody CreateAccountDto createAccountDto) {
        AccountDto accountDto = accountService.openAccount(createAccountDto);
        return ApiResponse.success(accountDto);
    }
}
