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
    
    private boolean profileFlag = true;
    
    private boolean routeFlag = true;
    
    private boolean ageFlag = true;
    
    private boolean areaFlag = true;
    
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
    
    public boolean isProfileFlag() {
        return profileFlag;
    }
    
    public void setProfileFlag(boolean profileFlag) {
        this.profileFlag = profileFlag;
    }

    public boolean isRouteFlag() {
        return routeFlag;
    }
    
    public void setRouteFlag(boolean routeFlag) {
        this.routeFlag = routeFlag;
    }
    
    public boolean isAgeFlag() {
        return ageFlag;
    }
    
    public void setAgeFlag(boolean ageFlag) {
        this.ageFlag = ageFlag;
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

    /**
     * @return the areaFlag
     */
    public boolean isAreaFlag() {
        return areaFlag;
    }

    /**
     * @param areaFlag the areaFlag to set
     */
    public void setAreaFlag(boolean areaFlag) {
        this.areaFlag = areaFlag;
    }
    
}
