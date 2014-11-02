/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sessionController;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author YusukeKato
 */
@Named(value = "twitterSession")
@SessionScoped
public class TwitterSession implements Serializable {
    
    /**
     * Creates a new instance of TwitterSession
     */
    public TwitterSession() {
    }
    
    private Twitter twitter;
    
    private RequestToken requestToken;
    
    private AccessToken accessToken;
    
    private long twitterID;
    
    @PostConstruct
    public void init(){
        setTwitter(new TwitterFactory().getInstance());
    }
    
    /**
     * @return the twitter
     */
    public Twitter getTwitter() {
        return twitter;
    }
    
    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }
    
    /**
     * @return the requestToken
     */
    public RequestToken getRequestToken() {
        return requestToken;
    }
    
    /**
     * @param requestToken the requestToken to set
     */
    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }
    
    /**
     * @return the accessToken
     */
    public AccessToken getAccessToken() {
        return accessToken;
    }
    
    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
   
}
