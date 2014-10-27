package id.co.skyforce.bankponsel.controller;

import java.io.Serializable;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.service.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class LoginController implements Serializable{

    public static String test = "Test";
    
    private String email;
    private String password;
    String url;
    UserProfile userProfile = new UserProfile();

    public String login(){
    	LoginService loginService = new LoginService();
        boolean result = loginService.login(email, password);
        if (result){
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(test, email);
            userProfile = new UserProfile();
            userProfile = loginService.getUserProfile();
           if(userProfile.getUserType() == 'C'){
        	   return "/userprofile/customer?faces-redirect=true";
           }
           else if(userProfile.getUserType() == 'M'){
        	   return "/userprofile/merchant?faces-redirect=true";
           }
           else
           {
        	   return "/userprofile/admin?faces-redirect=true";
           }
        }
        else{
        	
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "login";
        }
    }

    public String logout(){
        LoginService ls = new LoginService();
        ls.logout();
        userProfile = null;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(test);
        return "/index"; 
    }

    public boolean isLoggedIn(){
        return FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get(test) != null;

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


    
}
