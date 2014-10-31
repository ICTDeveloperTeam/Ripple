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
 *
 * @author YusukeKato
 */
@Entity
@XmlRootElement
public class PeopleAround implements Serializable{
    @Id
    private String otherMacAdr;
    private String nickName;
    private String prefecture;
    private String introduction;
    private String route;
    private String imagePath;

    /**
     * @return the otherMacAdr
     */
    public String getOtherMacAdr() {
        return otherMacAdr;
    }

    /**
     * @param otherMacAdr the otherMacAdr to set
     */
    public void setOtherMacAdr(String otherMacAdr) {
        this.otherMacAdr = otherMacAdr;
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

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
}
