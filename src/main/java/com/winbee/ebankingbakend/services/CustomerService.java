package com.winbee.ebankingbakend.services;

import com.winbee.ebankingbakend.dtos.CustomerDto;
import com.winbee.ebankingbakend.entities.Customer;
import com.winbee.ebankingbakend.mappers.CustomerMapper;
import com.winbee.ebankingbakend.repositories.BankAccountRepository;
import com.winbee.ebankingbakend.repositories.CustomerRepository;
import com.winbee.ebankingbakend.repositories.OperationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private OperationRepository operationRepository;
    private CustomerMapper customerMapper;

    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer customer = customerMapper.fromCustomerDto(customerDto);
        Customer savedcustomer =customerRepository.save(customer);
        return customerMapper.fromCustomer(savedcustomer);
    }
    public CustomerDto getCustomer(String customerID){
        Customer customer = new Customer();
        customer=customerRepository.findById(customerID).orElseThrow();
        return customerMapper.fromCustomer(customer);

    }

}
