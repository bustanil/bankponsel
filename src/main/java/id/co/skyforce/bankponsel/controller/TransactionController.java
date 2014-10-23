package id.co.skyforce.bankponsel.controller;

import java.math.BigDecimal;

import id.co.skyforce.bankponsel.service.TransactionService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TransactionController {

	TransactionService transactionService;
	private String userAccount ;
	private BigDecimal amount ;
	
	
	
	public TransactionController() {
		transactionService = new TransactionService();
		this.userAccount = userAccount;
		this.amount = amount;
	}

	public String deposit(){
		transactionService.deposit(userAccount, amount);
		
		return "succes";
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
