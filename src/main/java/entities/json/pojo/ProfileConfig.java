/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.json.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author YusukeKato
 */
@Entity
@XmlRootElement
public class ProfileConfig implements Serializable{
    @Id
    private String twitterID;
    private String twitterAccessToken;
    private String macAdr;
    private String regID;
    private String nickName;
    private String prefecture;
    private String introduction;
    private String route;

    public ProfileConfig(){
        
    }
    
    /**
     * @return the twitterID
     */
    public String getTwitterID() {
        return twitterID;
    }

    /**
     * @param twitterID the twitterID to set
     */
    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }

    /**
     * @return the twitterAccessToken
     */
    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }

    /**
     * @param twitterAccessToken the twitterAccessToken to set
     */
    public void setTwitterAccessToken(String twitterAccessToken) {
        this.twitterAccessToken = twitterAccessToken;
    }

    /**
     * @return the macAdr
     */
    public String getMacAdr() {
        return macAdr;
    }

    /**
     * @param macAdr the macAdr to set
     */
    public void setMacAdr(String macAdr) {
        this.macAdr = macAdr;
    }

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {
        this.regID = regID;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the prefecture
     */
    public String getPrefecture() {
        return prefecture;
    }

    /**
     * @param prefecture the prefecture to set
     */
    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    /**
     * @return the introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction the introduction to set
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }
}
