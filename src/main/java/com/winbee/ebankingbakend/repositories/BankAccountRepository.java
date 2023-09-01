package com.winbee.ebankingbakend.repositories;

import com.winbee.ebankingbakend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
