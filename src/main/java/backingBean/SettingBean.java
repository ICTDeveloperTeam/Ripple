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
    UserMasterFacade umejb = new UserMasterFacade();
    
    private String nickName = null;
    
    private String profile = null;
    
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
       return umejb.getNickName("mayuyuyu0106");
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
   
    public String getRoute() {
        return umejb.getRoute("");
    }
    
    public void setRoute(String route) {
        this.route = route;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
}
