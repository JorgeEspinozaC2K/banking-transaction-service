package com.banking.transaction.service.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transaction.service.app.model.Transaction;
import com.banking.transaction.service.app.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/usuario")
public class TransactionController {
	
	//dependency injection required for the class work
	@Autowired
	private TransactionService transactionService;
	
	//This method displays all the information from the transaction database
	@GetMapping
	public Flux<Transaction> index(){
		return transactionService.findAll();
		}
	
	//This method save or update a record from the transaction database
	@PostMapping("/save")
	public Mono<Transaction> save(@RequestBody Transaction transaction){
		return transactionService.save(transaction);
	}
}
