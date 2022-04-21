package com.banking.transaction.service.app.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.banking.transaction.service.app.entity.Account;

import reactor.core.publisher.Mono;

public class TransactionWebClient {

	private Builder transactionWebClient = WebClient.builder();
	
	public Mono<Account> findAccount(String id){
		return transactionWebClient.build()
				.get()
				.uri("http://localhost:8088/{id}",id)
				.retrieve()
				.bodyToMono(Account.class);
	}
	
}
