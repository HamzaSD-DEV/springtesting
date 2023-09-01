package com.winbee.ebankingbakend.repositories;

import com.winbee.ebankingbakend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<AccountOperation , Long> {
}
