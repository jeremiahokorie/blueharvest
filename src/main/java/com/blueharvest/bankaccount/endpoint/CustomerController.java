package com.blueharvest.bankaccount.endpoint;

import com.blueharvest.bankaccount.dto.CustomerDto;
import com.blueharvest.bankaccount.service.CustomerService;
import com.blueharvest.bankaccount.util.ApiResponse;
import com.blueharvest.bankaccount.util.AppConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstant.BASE_URL)
@AllArgsConstructor
public class CustomerController {

   private final CustomerService customerService;

    @GetMapping("customer/{customerId}")
    public ApiResponse<CustomerDto> customerDetails(@PathVariable  Long customerId) {
        CustomerDto customerDto = customerService.getCustomerInfo(customerId);
        return ApiResponse.success(customerDto);
    }
}
