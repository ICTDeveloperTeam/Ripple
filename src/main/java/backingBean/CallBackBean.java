/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backingBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import sessionController.TwitterSession;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;

/**
 *
 * @author YusukeKato
 */
@Named(value = "callBackBean")
@RequestScoped
public class CallBackBean {
    
    /**
     * Creates a new instance of CallBackBean
     */
    public CallBackBean() {
    }
    
    @Inject
    private TwitterSession twitterBean;
    
    
    private String oauthToken;
    
    private String oauthVerifier;
    
    private String loginUserName;
    
    public void preRender(){
        try {
            AccessToken accessToken = twitterBean.getTwitter().getOAuthAccessToken(twitterBean.getRequestToken(), getOauthVerifier());
            twitterBean.getTwitter().setOAuthAccessToken(accessToken);
            twitterBean.setAccessToken(accessToken);
            User user = twitterBean.getTwitter().showUser(accessToken.getUserId());
            setLoginUserName(user.getName());
        } catch (TwitterException ex) {
            Logger.getLogger(CallBackBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the oauthToken
     */
    public String getOauthToken() {
        return oauthToken;
    }

    /**
     * @param oauthToken the oauthToken to set
     */
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    /**
     * @return the oauthVerifier
     */
    public String getOauthVerifier() {
        return oauthVerifier;
    }

    /**
     * @param oauthVerifier the oauthVerifier to set
     */
    public void setOauthVerifier(String oauthVerifier) {
        this.oauthVerifier = oauthVerifier;
    }

    /**
     * @return the loginUserName
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * @param loginUserName the loginUserName to set
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }
    
}
