/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backingBean;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessionController.TwitterSession;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

/**
 *
 * @author YusukeKato
 */
@Named(value = "twitterLoginBean")
@RequestScoped
public class TwitterLoginBean {
    
    @Inject
    private TwitterSession twitterSession;
    
    @PostConstruct
    public void init(){
        if(twitterSession != null){
            twitterSession.getTwitter().setOAuthConsumer("qfWDW2SxzL5fibiYR8GvCGiiJ", "7SjoltMh1FwztLctNE9JVPJNzAXBNV9Du9FB0q8fuwNPc0nV5M");
        }
    }
    
    public void twitterLogin() throws TwitterException, IOException{
        RequestToken requestToken = twitterSession.getTwitter().getOAuthRequestToken("http://localhost:8080/Ripple/faces/views/main.xhtml");
        twitterSession.setRequestToken(requestToken);
        ExternalContext externalContet = FacesContext.getCurrentInstance().getExternalContext();
        externalContet.redirect(requestToken.getAuthenticationURL());
    }
}
