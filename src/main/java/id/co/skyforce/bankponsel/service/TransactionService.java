package id.co.skyforce.bankponsel.service;

import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		BigDecimal balance = virtualAccount.getBalance();
		if (virtualAccount.getAccountNo() == userAccount) {
			virtualAccount.setBalance(virtualAccount.getBalance().add(amount));
		}else{
			String message= "Account Number not Found in Virtual Account";
			JFrame frame = new JFrame("Error");
			JOptionPane.showMessageDialog(frame, message);
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
