/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YusukeKato
 */
@Entity
@Table(name = "UserMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserID", query = "SELECT u FROM UserMaster u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserMaster.findByDevToken", query = "SELECT u FROM UserMaster u WHERE u.devToken = :devToken"),
    @NamedQuery(name = "UserMaster.findByImagePath", query = "SELECT u FROM UserMaster u WHERE u.imagePath = :imagePath"),
    @NamedQuery(name = "UserMaster.findByIntroduction", query = "SELECT u FROM UserMaster u WHERE u.introduction = :introduction"),
    @NamedQuery(name = "UserMaster.findByMacAdr", query = "SELECT u FROM UserMaster u WHERE u.macAdr = :macAdr"),
    @NamedQuery(name = "UserMaster.findByNickName", query = "SELECT u FROM UserMaster u WHERE u.nickName = :nickName"),
    @NamedQuery(name = "UserMaster.findByPrefecture", query = "SELECT u FROM UserMaster u WHERE u.prefecture = :prefecture"),
    @NamedQuery(name = "UserMaster.findByRegID", query = "SELECT u FROM UserMaster u WHERE u.regID = :regID"),
    @NamedQuery(name = "UserMaster.findByRegisterDate", query = "SELECT u FROM UserMaster u WHERE u.registerDate = :registerDate"),
    @NamedQuery(name = "UserMaster.findByRoute", query = "SELECT u FROM UserMaster u WHERE u.route = :route"),
    @NamedQuery(name = "UserMaster.findByTwitterAccessToken", query = "SELECT u FROM UserMaster u WHERE u.twitterAccessToken = :twitterAccessToken"),
    @NamedQuery(name = "UserMaster.findByTwitterID", query = "SELECT u FROM UserMaster u WHERE u.twitterID = :twitterID")})
public class UserMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Size(max = 255)
    @Column(name = "DevToken")
    private String devToken;
    @Size(max = 255)
    @Column(name = "ImagePath")
    private String imagePath;
    @Size(max = 255)
    @Column(name = "introduction")
    private String introduction;
    @Size(max = 255)
    @Column(name = "MacAdr")
    private String macAdr;
    @Size(max = 255)
    @Column(name = "NickName")
    private String nickName;
    @Size(max = 255)
    @Column(name = "prefecture")
    private String prefecture;
    @Size(max = 255)
    @Column(name = "RegID")
    private String regID;
    @Column(name = "RegisterDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Size(max = 255)
    @Column(name = "Route")
    private String route;
    @Size(max = 255)
    @Column(name = "TwitterAccessToken")
    private String twitterAccessToken;
    @Size(max = 255)
    @Column(name = "TwitterID")
    private String twitterID;

    public UserMaster() {
    }

    public UserMaster(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMacAdr() {
        return macAdr;
    }

    public void setMacAdr(String macAdr) {
        this.macAdr = macAdr;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }

    public void setTwitterAccessToken(String twitterAccessToken) {
        this.twitterAccessToken = twitterAccessToken;
    }

    public String getTwitterID() {
        return twitterID;
    }

    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserMaster[ userID=" + userID + " ]";
    }
    
}
