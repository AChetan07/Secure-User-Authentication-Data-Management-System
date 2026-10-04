package com.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xyz.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCustomerCustomerId(Long customerId);

    boolean existsByAccountNumber(String accountNumber);

    @Query("select coalesce(sum(a.balance), 0) from Account a")
    double totalDeposits();

    @Query("select a.customer.city, coalesce(sum(a.balance), 0) from Account a group by a.customer.city")
    List<Object[]> depositsByCity();
}
