/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import twitter4j.Twitter;

/**
 *
 * @author YusukeKato
 */
@Named(value = "userDataBean")
@SessionScoped
public class UserDataBean implements Serializable {

    Twitter twitter;
    
    /**
     * Creates a new instance of UserDataBean
     */
    public UserDataBean() {
    }
    
    public boolean isLogged(){
        
        return false;
    }
}
