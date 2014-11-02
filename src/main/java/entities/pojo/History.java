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
public class History implements Serializable{
    @Id
    private String otherMacAdr;
    private String nickName;
    private int contactType;
    private String message;
    private String twitterID;
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
     * @return the contactType
     */
    public int getContactType() {
        return contactType;
    }

    /**
     * @param contactType the contactType to set
     */
    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
    
}
