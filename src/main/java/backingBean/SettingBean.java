package backingBean;

import ejb.UserMasterFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author YusukeKato
 */
@Named(value = "settingBean")
@SessionScoped
public class SettingBean implements Serializable {
    
    @EJB
    private UserMasterFacade umejb;
    
    private String nickName = null;
    
    private String introduction = null;
    
    private String prefecture=null;
    
    private String route = null;
    
    private String age = null;
    
    private String twitter = null;
    
    private boolean publicRangeFlag = true;
    
    private boolean notificationFlag = true;
    
    private List<String> ageList = new ArrayList<String>();
    
    public SettingBean() {
        int i=0;
        this.ageList.add("10代");
        for (int j = 20; j < 70; j+=5,i++) {
            this.ageList.add(j+"代");
        }
        this.ageList.add("70歳以上");
    }
    
    public String getNickName() {
        this.nickName=umejb.getNickName("mayuyuyu0106");
       return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName=nickName;
        umejb.setNickName("mayuyuyu0106",this.nickName);
    }
   
    public String getRoute() {
        this.route=umejb.getRoute("小田急");
        return this.route;
    }
    
    public void setRoute(String route) {
        this.route=route;
        umejb.setRoute("mayuyuyu0106", this.route);
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public List<String> getAgeList() {
        return ageList;
    }
    
    public void setAgeList(List<String> ageList) {
        this.ageList = ageList;
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
        this.introduction=umejb.getIntroduction("mayuyuyu0106");
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction=introduction;
        umejb.setIntroduction("mayuyuyu0106", this.introduction);
    }
    
    public String getPrefecture(){
        this.prefecture=umejb.getPrefecture("mayuyuyu0106");
        return this.prefecture;
    }
    
    public void setPrefecture(String prefecture){
        this.prefecture=prefecture;
        umejb.setPrefecture("mayuyuyu0106", this.prefecture);
    }
    
    
}
