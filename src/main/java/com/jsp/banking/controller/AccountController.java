package com.jsp.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.banking.dto.Account;
import com.jsp.banking.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	// Create Account REST API

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	// Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		Account getAccount = accountService.getAccountById(id);
		return ResponseEntity.ok(getAccount);
	}
	// DEPOSIT REST API

	@PutMapping("/{id}/deposit")
	public ResponseEntity<Account> deposit(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		Account deposit = accountService.deposit(id, amount);
		return ResponseEntity.ok(deposit);

	}
	// WITHDRAW REST API

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<Account> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double withdraw = request.get("amount");
		Account withdrawAmount = accountService.withdraw(id, withdraw);
		return ResponseEntity.ok(withdrawAmount);

	}
	
	// GET ALL ACCOUNTS REST API

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getallaccounts() {
		List<Account> accountlist = accountService.getallaccounts();
		return ResponseEntity.ok(accountlist);

	}

}
