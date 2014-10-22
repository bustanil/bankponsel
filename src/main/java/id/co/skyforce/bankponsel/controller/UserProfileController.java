package id.co.skyforce.bankponsel.controller;

import java.util.ArrayList;
import java.util.List;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.service.UserProfileService;

import javax.faces.bean.ManagedBean;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
public class UserProfileController {

	//public UserProfileController() {
		//super();
	//}
	
//	UserProfileService userService = new UserProfileService();
//	UserProfile userProfile = new UserProfile();
//	List<UserProfile> listUser;
//	
//	
//	public UserProfileController() {
//		listUser = new ArrayList<>();
//		userService  = new UserProfileService();
//		UserProfile userProfile = new UserProfile();
//		listUser = userService.getAll();
//	}
//
//
//	public UserProfileService getUserService() {
//		return userService;
//	}
//
//
//	public void setUserService(UserProfileService userService) {
//		this.userService = userService;
//	}
//
//
//	public UserProfile getUserProfile() {
//		return userProfile;
//	}
//
//
//	public void setUserProfile(UserProfile userProfile) {
//		this.userProfile = userProfile;
//	}
//
//
//	public List<UserProfile> getListUser() {
//		return listUser;
//	}
//
//
//	public void setListUser(List<UserProfile> listUser) {
//		this.listUser = listUser;
//	}
	
	
private List<UserProfile> users;
	
	
public List<UserProfile> getUsers() {
	return users;
}


public void setUsers(List<UserProfile> users) {
	this.users = users;
}


public UserProfileController() {
	Session session = id.co.skyforce.bankponsel.util.HibernateUtil.openSession();
	
	Query q = session.createQuery("from UserProfile");
	users = q.list();
	
	session.close();
	
}
	

	

}
