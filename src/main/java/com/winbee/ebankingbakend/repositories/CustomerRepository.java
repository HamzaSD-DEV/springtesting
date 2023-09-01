package com.winbee.ebankingbakend.repositories;

import com.winbee.ebankingbakend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}
