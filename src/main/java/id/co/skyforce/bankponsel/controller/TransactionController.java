package id.co.skyforce.bankponsel.controller;

import java.math.BigDecimal;
import java.util.Date;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.service.TransactionService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TransactionController {
	@ManagedProperty(value ="#{loginController}")
	private LoginController loginController;

	TransactionService transactionService = new TransactionService();
	private String userAccount ;
	private BigDecimal amount ;
	UserProfile userProfile ;
	
	private String targetAccountNo;
	private String nameProduct;
	private String mobileNo;
	
	@ManagedProperty(value ="#{ProductController}")
	private ProductController productController;
	
	public void clear(){
		userAccount = "";
		amount = null;
	}
	
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
		
	}

	public String deposit(){
		String deposit = transactionService.deposit(userAccount, amount);
		clear();
		return deposit;
	}
	
	public String withdrawl(){
		String withdrawl = transactionService.withdrawl(userAccount, amount);
		clear();
		return withdrawl;
	}

	public String transfer(){
		
		transactionService.transfer(loginController.userProfile.getMobileNo(), targetAccountNo, amount);
		clear();
		return "transfer";
	}

	public String purchase(){
		transactionService.purchase(nameProduct, loginController.userProfile.getMobileNo());
		clear();
		return "purchaseItem";
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public ProductController getProductController() {
		return productController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}


	
	
	
}
