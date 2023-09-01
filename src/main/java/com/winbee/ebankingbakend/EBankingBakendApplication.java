package com.winbee.ebankingbakend;

import com.winbee.ebankingbakend.entities.AccountOperation;
import com.winbee.ebankingbakend.entities.CurrentAccount;
import com.winbee.ebankingbakend.entities.Customer;
import com.winbee.ebankingbakend.entities.SavingAccount;
import com.winbee.ebankingbakend.enums.AccountStatus;
import com.winbee.ebankingbakend.enums.OperationType;
import com.winbee.ebankingbakend.repositories.BankAccountRepository;
import com.winbee.ebankingbakend.repositories.CustomerRepository;
import com.winbee.ebankingbakend.repositories.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankingBakendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankingBakendApplication.class, args);
    }

    @Bean
    CommandLineRunner start (BankAccountRepository bankAccountRepository,
                            CustomerRepository customerRepository,
                            OperationRepository operationRepository){
        return args -> {
            Stream.of("alex","bruno","amelie").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setBalance(Math.random()*1000);
                currentAccount.setOverDraft(2000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCurrency("TND");
                currentAccount.setCustomer(customer);
                bankAccountRepository.save(currentAccount);
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setBalance(Math.random()*1000);
                savingAccount.setInterestRate(4.5);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCurrency("TND");
                savingAccount.setCustomer(customer);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(bankAccount -> {
                for (int i= 0 ; i<10 ; i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setBankAccount(bankAccount);
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setType(Math.random()<0.5 ? OperationType.DEBIT : OperationType.CREDIT );
                    accountOperation.setAmount(Math.random()*1000);
                    operationRepository.save(accountOperation);
                }

            });
        };

    }
}
