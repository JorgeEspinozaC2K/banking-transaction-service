package com.banking.transaction.service.app.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.transaction.service.app.model.Transaction;
import com.banking.transaction.service.app.repository.TransactionRepository;
import com.banking.transaction.service.app.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImp implements TransactionService{

	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImp.class);
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

	@Override
	public Flux<Transaction> findByAccountId(String accountId) {
		return transactionRepository.findByAccountId(accountId)
				.defaultIfEmpty(new Transaction())
				.flatMap(_Transaction -> _Transaction.getId() == null ?
						Mono.error(new InterruptedException("Not Found")):
							Flux.just(_Transaction)
							)
				.onErrorResume(_ex ->{
					log.error(_ex.getMessage());
					return Mono.empty();
					});
	}
}
