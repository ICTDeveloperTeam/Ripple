/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package renderFlags;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author YusukeKato
 */
@Named(value = "settingFlags")
@SessionScoped
public class SettingFlags implements Serializable {
    
    private boolean nickNameFlag = true;
    
    private boolean hobbyFlag = true;
    
    private boolean likeItFlag = true;
    
    private boolean routeFlag = true;
    
    private boolean jobFlag = true;
    
    private boolean ageFlag = true;
    
    private boolean gmailFlag = true;
    
    private boolean twitterFlag = true;
    
    private boolean trueFlag = true;
    
    public SettingFlags() {
    }
    
    public boolean isNickNameFlag() {
        return nickNameFlag;
    }
    
    public void setNickNameFlag(boolean nickNameFlag) {
        this.nickNameFlag = nickNameFlag;
    }
    
    public boolean isHobbyFlag() {
        return hobbyFlag;
    }
    
    public void setHobbyFlag(boolean hobbyFlag) {
        this.hobbyFlag = hobbyFlag;
    }
    
    public boolean isLikeItFlag() {
        return likeItFlag;
    }
    
    public void setLikeItFlag(boolean likeItFlag) {
        this.likeItFlag = likeItFlag;
    }
    
    public boolean isRouteFlag() {
        return routeFlag;
    }
    
    public void setRouteFlag(boolean routeFlag) {
        this.routeFlag = routeFlag;
    }
    
    public boolean isJobFlag() {
        return jobFlag;
    }
    
    public void setJobFlag(boolean jobFlag) {
        this.jobFlag = jobFlag;
    }
    
    public boolean isAgeFlag() {
        return ageFlag;
    }
    
    public void setAgeFlag(boolean ageFlag) {
        this.ageFlag = ageFlag;
    }
    
    public boolean isGmailFlag() {
        return gmailFlag;
    }
    
    public void setGmailFlag(boolean gmailFlag) {
        this.gmailFlag = gmailFlag;
    }
    
    public boolean isTwitterFlag() {
        return twitterFlag;
    }
    
    public void setTwitterFlag(boolean twitterFlag) {
        this.twitterFlag = twitterFlag;
    }
    
    public boolean isTrueFlag() {
        return trueFlag;
    }
    
    public void setTrueFlag(boolean trueFlag) {
        this.trueFlag = trueFlag;
    }
    
}
