package id.co.skyforce.bankponsel.service;

import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.bankponsel.model.TransactionLog;
import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.model.VirtualAccount;
import id.co.skyforce.bankponsel.util.HibernateUtil;

public class TransactionService {

	 UserProfile userProfile = new UserProfile();
	 VirtualAccount virtualAccount;

	public void deposit(String userAccount, BigDecimal amount){
		
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, userAccount);
		
		if (virtualAccount.getAccountNo() == userAccount) {
			virtualAccount.setBalance(virtualAccount.getBalance().add(amount));
			
			TransactionLog log = new TransactionLog();
			log.setTransactionDate(new Date());
			log.setAmount(amount);
			log.setDbCr('D');
			log.setVirtualAccount(virtualAccount);
			session.save(log);
			
		}else{
			String message= "Account Number not Found in Virtual Account";
			JFrame frame = new JFrame("Error");
			JOptionPane.showMessageDialog(frame, message);
		}
		session.saveOrUpdate(virtualAccount);
		trx.commit();
		session.close();
	}
	 
	public static void withdrawl(String accountNo,BigDecimal amount){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		VirtualAccount virtualAccount = (VirtualAccount) session.get(VirtualAccount.class, accountNo);
		
		if (accountNo == virtualAccount.getAccountNo()) {
			virtualAccount.setBalance(new BigDecimal(virtualAccount.getBalance().doubleValue() - amount.doubleValue()));
			
			TransactionLog log = new TransactionLog();
			log.setTransactionDate(new Date());
			log.setAmount(amount);
			log.setDbCr('C');
			log.setVirtualAccount(virtualAccount);
			session.save(log);
		}
		session.saveOrUpdate(virtualAccount);
		trx.commit();
		session.close();
	}
	
	public static void transfer(String accountNo,String targetAccountNo, BigDecimal amount){
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
				
			}
		}
		session.saveOrUpdate(virtualAccount);
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

}
