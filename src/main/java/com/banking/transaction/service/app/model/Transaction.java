package com.banking.transaction.service.app.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class Transaction {
	
	@Id
	private String id;
	private Boolean fromCard;
	private Long cardNumber;
	private Boolean bankDraft;
	private	Boolean externalAccount;
	private Integer personalIdentifierDestiny;
	private Integer personalIdentifierCharge;
	//charge account
	private Long numberChargeAccount;
	//own account, another bank account, abroad
	private Integer typeAccount;
	//destination account
	private Long numberDestiantionAccount;
	//amount to transfer
	private Double amount;
	//Status transaction approved or rejected
	private Integer status;
	//Operation date
	private LocalDate operationDate = LocalDate.now();

}
