package id.co.skyforce.bankponsel.service;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserProfileService {

	private UserProfileService userProfile;

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
		
		trx.commit();
		session.close();
	}
	
	
	
	public UserProfileService getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileService userProfile) {
		this.userProfile = userProfile;
	}
}
