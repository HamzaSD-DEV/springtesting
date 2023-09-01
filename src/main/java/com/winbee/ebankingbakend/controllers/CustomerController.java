package com.winbee.ebankingbakend.controllers;

import com.winbee.ebankingbakend.dtos.CustomerDto;
import com.winbee.ebankingbakend.entities.Customer;
import com.winbee.ebankingbakend.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionService;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private CustomerService customerService;
    @PostMapping ("/custromers")
    public CustomerDto addCustomers(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }
    public CustomerDto getCustomer(@PathVariable String customerID){
        return customerService.getCustomer(customerID);
    }
}
