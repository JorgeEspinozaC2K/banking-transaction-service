package com.banking.transaction.service.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.banking.transaction.service.app.model.Transaction;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
