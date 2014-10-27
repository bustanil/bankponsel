package id.co.skyforce.bankponsel.service;

import java.util.List;

import javax.faces.context.FacesContext;

import id.co.skyforce.bankponsel.model.UserProfile;
import id.co.skyforce.bankponsel.util.HibernateUtil;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginService {

	
    //String url;

    UserProfile userProfile = new UserProfile();
    public boolean login(String email, String password){
    	Session session = HibernateUtil.openSession();
    	Transaction trx = session.beginTransaction();
        Query query = session.createQuery("from UserProfile c where c.email=:email and c.password=:password");
        query.setString("email", email);
        query.setString("password", password);
        List<UserProfile> result = query.list();
        trx.commit();
        session.close();
        if (!result.isEmpty()){
            userProfile = result.get(0);
            return true;
        }
        else {
            return false;
        }
    }
    

    
    public UserProfile getUserProfile() {
		return userProfile;
    }

	public String logout(){
        userProfile= null; 
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         return "/index";
    }


    
}
