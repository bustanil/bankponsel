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
		Transaction trx = session.beginTransaction();
		
		List<UserProfile> listUser = session.createQuery("from UserProfile").list();
		
		trx.commit();
		session.close();
		return listUser;
	}
	
	public UserProfileService getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileService userProfile) {
		this.userProfile = userProfile;
	}
}
