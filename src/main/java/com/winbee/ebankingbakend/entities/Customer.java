package com.winbee.ebankingbakend.entities;

import com.winbee.ebankingbakend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy =GenerationType.UUID)
    private String id;
    private String name;
    private  String email;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> accountList;

}
