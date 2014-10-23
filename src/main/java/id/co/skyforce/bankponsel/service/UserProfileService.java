package id.co.skyforce.bankponsel.service;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.model.VirtualAccount;
import id.co.skyforce.bankponsel.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserProfileService {

	private UserProfileService userProfile;
	private VirtualAccount virtualAccount;

	public List<UserProfile> getAll(){
		Session session = HibernateUtil.openSession();
		
		List<UserProfile> listUser = session.createQuery("from UserProfile").list();
		
		session.close();
		return listUser;
	}
	
	
	public void insertUser(UserProfile user){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(user);
		user = (UserProfile) session.get(UserProfile.class, user.getId());
	virtualAccount = new VirtualAccount();
//		virtualAccount.setAccountNo(user.getMobileNo());
virtualAccount.setBalance(new BigDecimal(0));
virtualAccount.setUserProfile(user);
session.save(virtualAccount);
		trx.commit();
		session.close();
	}
	
	
	
	public VirtualAccount getVirtualAccount() {
		return virtualAccount;
	}

	public void setVirtualAccount(VirtualAccount virtualAccount) {
		this.virtualAccount = virtualAccount;
	}


	public UserProfileService getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileService userProfile) {
		this.userProfile = userProfile;
	}
}
