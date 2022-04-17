package com.banking.transaction.service.app.model;

import java.util.Date;

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
	private Boolean bankDraft;
	private	Boolean externalAccount;
	private int personalIdentifierDestiny;
	private int personalIdentifierCharge;
	private int moneyType;
	//charge account
	private Long numberChargeAccount;
	//own account, another bank account, abroad
	private int typeAccount;
	//destination account
	private Long numberDestiantionAccount;
	//amount to transfer
	private Double amount;
	//Verification pin
	private String password;
	//Status transaction approved or rejected
	private int status;
	//Operation date
	private Date operationDate;

}
