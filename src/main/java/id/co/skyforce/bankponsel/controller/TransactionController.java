package id.co.skyforce.bankponsel.controller;

import java.math.BigDecimal;
import java.util.Date;

import id.co.skyforce.bankponsel.service.TransactionService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TransactionController {

	TransactionService transactionService;
	private String userAccount ;
	private BigDecimal amount ;
	
	//
	private String targetAccountNo;
	private String nameProduct;
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getTargetAccountNo() {
		return targetAccountNo;
	}

	public void setTargetAccountNo(String targetAccountNo) {
		this.targetAccountNo = targetAccountNo;
	}
	//

	public TransactionController() {
		transactionService = new TransactionService();
//		this.userAccount = userAccount;
//		this.amount = amount;
//		this.targetAccountNo=targetAccountNo;
		
	}

	public String deposit(){
		transactionService.deposit(userAccount, amount);
		
		return "succes";
	}
	
	public String withdrawl(){
		transactionService.withdrawl(userAccount, amount);
		
		return "succes";
	}

	public String transfer(){
		transactionService.transfer(userAccount, targetAccountNo, amount);
		
		return "succes";
	}

	public String purchase(){
		transactionService.purchase(nameProduct, userAccount);
		
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
