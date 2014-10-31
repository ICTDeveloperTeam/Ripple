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
public class ContactData implements Serializable{
    @Id
    private String myMacAdr;
    private String otherMacAdr;
    private int contactType;
    private String message;
    private boolean openFlag;

    /**
     * @return the myMacAdr
     */
    public String getMyMacAdr() {
        return myMacAdr;
    }

    /**
     * @param myMacAdr the myMacAdr to set
     */
    public void setMyMacAdr(String myMacAdr) {
        this.myMacAdr = myMacAdr;
    }

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
     * @return the openFlag
     */
    public boolean isOpenFlag() {
        return openFlag;
    }

    /**
     * @param openFlag the openFlag to set
     */
    public void setOpenFlag(boolean openFlag) {
        this.openFlag = openFlag;
    }
}
