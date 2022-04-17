package com.banking.transaction.service.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.transaction.service.app.model.Transaction;
import com.banking.transaction.service.app.repository.TransactionRepository;
import com.banking.transaction.service.app.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{

	/**
	 * Dependency injection required for the class work 
	 */
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Flux<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Mono<Transaction> findByid(String id) {
		return transactionRepository.findById(id);
	}

	@Override
	public Mono<Transaction> save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public Mono<Void> delete(Transaction transaction) {
		return transactionRepository.delete(transaction);
	}
}
