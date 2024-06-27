package com.jsp.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.banking.dto.Account;
import com.jsp.banking.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));

	}

	public Account deposit(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		Double total = account.getBalance() + amount;
		account.setBalance(total);
		return accountRepository.save(account);
	}

	public Account withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		return accountRepository.save(account);
	}

	public List<Account> getallaccounts() {
		return accountRepository.findAll();
	}

}
