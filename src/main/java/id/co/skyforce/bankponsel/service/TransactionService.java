package id.co.skyforce.bankponsel.service;

import java.math.BigDecimal;
import java.util.Date;




import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.bankponsel.controller.LoginController;
import id.co.skyforce.bankponsel.model.Product;
import id.co.skyforce.bankponsel.model.TransactionLog;
import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.model.VirtualAccount;
import id.co.skyforce.bankponsel.util.HibernateUtil;

public class TransactionService {

	 UserProfile userProfile = new UserProfile();
	 VirtualAccount virtualAccount; 
	 static FacesMessage message;
	
	 public String deposit(String userAccount, BigDecimal amount){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, userAccount);
		session.close();
		
		if (virtualAccount == null) {
			
			message = new FacesMessage("Account Number Not Found");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "/transaction/deposit";
		}else{
			if (amount.doubleValue() > 0) {
				 session = HibernateUtil.openSession();
				 trx = session.beginTransaction();
				
				virtualAccount.setBalance(virtualAccount.getBalance().add(amount));
				
				TransactionLog log = new TransactionLog();
				log.setTransactionDate(new Date());
				log.setAmount(amount);
				log.setDbCr('D');
				log.setVirtualAccount(virtualAccount);
				session.save(log);
				
				session.saveOrUpdate(virtualAccount);
				trx.commit();
				session.close();
				
				message = new FacesMessage("Deposit Succes");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				return "/transaction/deposit";
			}else{
				message = new FacesMessage("Deposit Must Greater Than 0");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "/transaction/deposit";
			}
		}
		
	}
	 
	public String withdrawl(String accountNo,BigDecimal amount){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		VirtualAccount virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, accountNo);
		session.close();
		if (virtualAccount == null) {
			
			message = new FacesMessage("Account Number Not Found");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return "/transaction/withdraw";
		}else{
			if (virtualAccount.getBalance().doubleValue() > amount.doubleValue() && amount.doubleValue() > 0) { // Check Drawing
				session = HibernateUtil.openSession();
				trx = session.beginTransaction();
				
				virtualAccount.setBalance(new BigDecimal(virtualAccount.getBalance().doubleValue() - amount.doubleValue()));
			
				TransactionLog log = new TransactionLog();
				log.setTransactionDate(new Date());
				log.setAmount(amount);
				log.setDbCr('C');
				log.setVirtualAccount(virtualAccount);
				session.save(log);
				session.saveOrUpdate(virtualAccount);
				trx.commit();
				session.close();
				
				message = new FacesMessage("Withdraw Success");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "/transaction/withdraw";
			}else{
				message = new FacesMessage("Your Withdrawl is Failed");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "/transaction/withdraw";
			}	
		
		}
		
		
		
	}
	
	public void transfer(String accountNo,String targetAccountNo, BigDecimal amount){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		VirtualAccount account = (VirtualAccount) session.get(VirtualAccount.class, accountNo);
		VirtualAccount virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, targetAccountNo);
		if (account.getUserProfile().getUserType().equals('C') && virtualAccount.getUserProfile().getUserType().equals('C')) {
			
			if (account.getBalance().doubleValue() > amount.doubleValue()) {

				account.setBalance(new BigDecimal(account.getBalance().doubleValue() - amount.doubleValue()));
				session.saveOrUpdate(account);
				
				TransactionLog log = new TransactionLog();
				log.setTransactionDate(new Date());
				log.setAmount(amount);
				log.setDbCr('C');
				log.setVirtualAccount(account);
				session.save(log);
				
				virtualAccount.setBalance(new BigDecimal(virtualAccount.getBalance().doubleValue() + amount.doubleValue()));
			
				log = new TransactionLog();
				log.setTransactionDate(new Date());
				log.setAmount(amount);
				log.setDbCr('D');
				log.setVirtualAccount(virtualAccount);
				session.save(log);
				message = new FacesMessage("Transfer  Success ");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				message = new FacesMessage("Your Balance Not Enough ");
				message.setSeverity(FacesMessage.SEVERITY_INFO);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		
		}else{
			message = new FacesMessage("Transfer Must Be Member To Member ! ");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		session.saveOrUpdate(virtualAccount);
		trx.commit();
		session.close();
	}
	
	public void purchase(String nameProduct, String accountNo){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, accountNo);
		
		Query query = session.createQuery("from Product p where p.name = :name");
		query.setString("name", nameProduct);
		Product product = (Product) query.uniqueResult();
		
		double bayar = 0;
	
		if (virtualAccount.getUserProfile().getUserType().equals('C')) {
			bayar = product.getPrice().doubleValue() + product.getMargin().doubleValue();
			virtualAccount.setBalance(new BigDecimal(virtualAccount.getBalance().doubleValue() - bayar));
		}else if(virtualAccount.getUserProfile().getUserType().equals('M')){
			bayar = product.getPrice().doubleValue() + (product.getMargin().multiply( product.getSharePercentage()).doubleValue());
			virtualAccount.setBalance(new BigDecimal(virtualAccount.getBalance().doubleValue() - bayar ));
			
		}
		TransactionLog log = new TransactionLog();
		log.setDbCr('C');
		log.setTransactionDate(new Date());
		log.setAmount(new BigDecimal(bayar));
		log.setVirtualAccount(getVirtualAccount());
		
		session.save(log);
		session.saveOrUpdate(virtualAccount);
		
		
		message = new FacesMessage("Purchase Success");
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		trx.commit();
		session.close();
	}
	


	public UserProfile getUserProfile() {
		return userProfile;
	}

	public VirtualAccount getVirtualAccount() {
		return virtualAccount;
	}

	public void setVirtualAccount(VirtualAccount virtualAccount) {
		this.virtualAccount = virtualAccount;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public FacesMessage getMessage() {
		return message;
	}

	public void setMessage(FacesMessage message) {
		this.message = message;
	}
	
	
}
