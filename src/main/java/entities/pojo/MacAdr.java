/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.json.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YusukeKato
 */
@Entity
@XmlRootElement
public class MacAdr implements Serializable{
    @Id
    private String myMacAdr;
    private List<String> otherMacAdr;

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
    public List<String> getOtherMacAdr() {
        return otherMacAdr;
    }

    /**
     * @param otherMacAdr the otherMacAdr to set
     */
    public void setOtherMacAdr(List<String> otherMacAdr) {
        this.otherMacAdr = otherMacAdr;
    }
    
}
