package com.banking.transaction.service.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.banking.transaction.service.app.model.Transaction;

import reactor.core.publisher.Flux;


public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

	public Flux<Transaction> findByAccountId(String accountId);
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public Flux<Transaction> findTop10ByCardNumberOrderByOperationDateDesc(Long cardNumber);
	
}
