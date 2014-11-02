package backingBean;

import ejb.UserMasterFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import sessionController.TwitterSession;

/**
 *
 * @author YusukeKato
 */
@Named(value = "settingBean")
@SessionScoped
public class SettingBean implements Serializable {
    
    @EJB
    private UserMasterFacade umejb;
    
    @Inject
    TwitterSession twitterSession;
    
    private String nickName = null;
    
    private String introduction = null;
    
    private String prefecture=null;
    
    private String route = null;
    
    private String twitter = null;
    
    private String twitterID=null;
    
    private boolean publicRangeFlag = true;
    
    private boolean notificationFlag = true;
    
    
    public SettingBean(){
    }
    
    public String getNickName() {
        this.nickName=umejb.getNickName(twitterID);
       return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName=nickName;
        umejb.setNickName(twitterID,this.nickName);
    }
   
    public String getRoute() {
        this.route=umejb.getRoute("小田急");
        return this.route;
    }
    
    public void setRoute(String route) {
        this.route=route;
        umejb.setRoute(twitterID, this.route);
    }
  
    public String getTwitter() {
        return twitter;
    }
    
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    public boolean isPublicRangeFlag() {
        return publicRangeFlag;
    }
    
    public void setPublicRangeFlag(boolean publicRangeFlag) {
        this.publicRangeFlag = publicRangeFlag;
    }
    
    public boolean isNotificationFlag() {
        return notificationFlag;
    }
    
    public void setNotificationFlag(boolean notificationFlag) {
        this.notificationFlag = notificationFlag;
    }
    
    /**
     * @return the umejb
     */
    public UserMasterFacade getUmejb() {
        return umejb;
    }
    
    /**
     * @param umejb the umejb to set
     */
    public void setUmejb(UserMasterFacade umejb) {
        this.umejb = umejb;
    }
    
    public String getIntroduction() {
        this.introduction=umejb.getIntroduction(twitterID);
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction=introduction;
        umejb.setIntroduction(twitterID, this.introduction);
    }
    
    public String getPrefecture(){
        this.prefecture=umejb.getPrefecture(twitterID);
        return this.prefecture;
    }
    
    public void setPrefecture(String prefecture){
        this.prefecture=prefecture;
        umejb.setPrefecture(twitterID, this.prefecture);
    }
    
    
}
