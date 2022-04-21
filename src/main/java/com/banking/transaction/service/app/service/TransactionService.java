package com.banking.transaction.service.app.service;

import com.banking.transaction.service.app.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

	/**
	 * This method bring all the information from Transaction database
	 * @return Flux type Transaction
	 */
	public Flux<Transaction> findAll();
	
	/**
	 * This method bring a record from transaction database
	 * @return Mono type Transaction
	 */
	public Mono<Transaction> findById(String id);
	
	/**
	 * This method save or update a record
	 * @return Mono type Transaction
	 */
	public Mono<Transaction> save(Transaction transaction);

	/**
	 * This method delete a record
	 * @return Mono type Void
	 */
	public Mono<Void> delete(Transaction transaction);
	
	/**
	 * This method finds the transactions of an account
	 * @param accountId
	 * @return
	 */
	public Flux<Transaction> findByAccountId(String accountId);
}
