package com.winbee.ebankingbakend.mappers;


import com.winbee.ebankingbakend.dtos.CustomerDto;
import com.winbee.ebankingbakend.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
public CustomerDto fromCustomer(Customer customer){
    CustomerDto customerDto = new CustomerDto();
    BeanUtils.copyProperties(customer,customerDto);
    return customerDto;
}
public Customer fromCustomerDto(CustomerDto customerDto){
    Customer customer = new Customer();
    BeanUtils.copyProperties(customerDto,customer);
    return customer;
}
}
