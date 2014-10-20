package backingBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author YusukeKato
 */
@Named(value = "settingBean")
@SessionScoped
public class SettingBean implements Serializable {
    
    private String nickName = null;
    
    private String hobby = null;
    
    private String likeIt = null;
    
    private String route = null;
    
    private String job = null;
    
    private String product = null;
    
    private String age = null;
    
    private String gmail = null;
    
    private String twitter = null;
    
    private boolean publicRangeFlag = true;
    
    private boolean notificationFlag = true;
    
    private List<SelectItem> ageList = new ArrayList<SelectItem>();
    
    public SettingBean() {
        int i=0;
        this.ageList.add(new SelectItem(i++, "10代"));
        for (int j = 20; j < 70; j+=5,i++) {
            this.ageList.add(new SelectItem(i, j+"代"));
        }
        this.ageList.add(new SelectItem(i, "70歳以上"));
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public String getHobby() {
        return hobby;
    }
    
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    public String getLikeIt() {
        return likeIt;
    }
    
    public void setLikeIt(String likeIt) {
        this.likeIt = likeIt;
    }
    
    public String getRoute() {
        return route;
    }
    
    public void setRoute(String route) {
        this.route = route;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public List<SelectItem> getAgeList() {
        return ageList;
    }
    
    public void setAgeList(List<SelectItem> ageList) {
        this.ageList = ageList;
    }
    
    public String getGmail() {
        return gmail;
    }
    
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
    public String getTwitter() {
        return twitter;
    }
    
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    public boolean isValue1() {
        return notificationFlag;
    }
    
    public void setValue1(boolean notificationFlag) {
        this.notificationFlag = notificationFlag;
    }
    
    public boolean isPublicRangeFlag() {
        return publicRangeFlag;
    }
    
    public void setPublicRangeFlag(boolean publicRangeFlag) {
        this.publicRangeFlag = publicRangeFlag;
    }
    
    public String getProduct() {
        return product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
    
    public boolean isNotificationFlag() {
        return notificationFlag;
    }
    
    public void setNotificationFlag(boolean notificationFlag) {
        this.notificationFlag = notificationFlag;
    }
    
}
