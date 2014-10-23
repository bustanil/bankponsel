package id.co.skyforce.bankponsel.controller;

import java.util.ArrayList;
import java.util.List;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.service.UserProfileService;

import javax.faces.bean.ManagedBean;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean (name ="userController")
public class UserProfileController {

	UserProfile userProfile = new UserProfile();  // model
	UserProfileService userService = new UserProfileService(); // service
	List<UserProfile> listUser; // listnya
	
	
	public UserProfileController() {
		listUser = new ArrayList<>();
		userService  = new UserProfileService();
		userProfile = new UserProfile();
		listUser = userService.getAll();
	}

	public String viewUser(){
		listUser = userService.getAll();
		return "list";
	}
	
	public String insert(){
	userService.insertUser(userProfile);
		
		
		listUser = userService.getAll();
		return "list";
	}
	
	public UserProfileService getUserService() {
		return userService;
	}


	public void setUserService(UserProfileService userService) {
		this.userService = userService;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public List<UserProfile> getListUser() {
		return listUser;
	}


	public void setListUser(List<UserProfile> listUser) {
		this.listUser = listUser;
	}
	

}
