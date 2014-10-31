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
public class Login implements Serializable{
    @Id
    private String twitterAccessToken;
    private String macAdr;

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
}
