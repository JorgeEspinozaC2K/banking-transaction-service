package com.banking.transaction.service.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.transaction.service.app.model.Transaction;
import com.banking.transaction.service.app.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	//dependency injection required for the class work
	@Autowired
	private TransactionService transactionService;
	
	//This method displays all the information from the transaction database
	@GetMapping
	public Flux<Transaction> index(){
		return transactionService.findAll();
		}
	
	@GetMapping("/{id}")
	public Mono<Transaction> findById(@PathVariable String id){
		return transactionService.findById(id);
	}
	
	//This method save or update a record from the transaction database
	@PostMapping("/save")
	public Mono<Transaction> save(@RequestBody Transaction transaction){
		return transactionService.save(transaction);
	}
	@DeleteMapping("/delete")
	public Mono<Void> delete(@RequestBody Transaction transaction){
		return transactionService.delete(transaction);
	}
	
	@GetMapping("/lastTen/{cardNumber}")
	public Flux<Transaction> findTenLast(@PathVariable Long cardNumber){
		return transactionService.findAllTenLast(cardNumber);
	}
	
}
