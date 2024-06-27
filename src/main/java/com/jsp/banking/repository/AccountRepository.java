package com.jsp.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.banking.dto.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}