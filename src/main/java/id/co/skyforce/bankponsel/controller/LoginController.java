package id.co.skyforce.bankponsel.controller;

import id.co.skyforce.bankponsel.service.LoginService;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginController {

	LoginService loginService;
	private String email;
	private String password;
	
	
	public LoginController() {
		this.loginService = loginService;
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
	
	public String login(){
		loginService.login(email,password);
		
		return "userprofile/succes";
	}
	
	public String logout(){
		loginService.loguot();
		return "logout";
	}
	
	
	
	
}
