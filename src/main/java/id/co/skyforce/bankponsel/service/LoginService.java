package id.co.skyforce.bankponsel.service;

import id.co.skyforce.bankponsel.model.UserProfile;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginService {

	UserProfile userProfile;
	
	
	public LoginService() {

		userProfile = new UserProfile();
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}


	public String login(String email, String password){
		FacesMessage msg;
		boolean loggedIn;
		

		if(userProfile.getEmail() != null){
			loggedIn = true;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", userProfile.getPassword());
			return "succes";
		}
		else{
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
			if(this.userProfile == null){
				this.userProfile = new UserProfile();
			}
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
			}
	
	public void loguot(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

	}

}
