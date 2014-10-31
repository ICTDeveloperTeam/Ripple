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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "UserMaster.findByTwitterID", query = "SELECT u FROM UserMaster u WHERE u.twitterID = :twitterID"),
    @NamedQuery(name = "UserMaster.findByTwitterAccessToken", query = "SELECT u FROM UserMaster u WHERE u.twitterAccessToken = :twitterAccessToken"),
    @NamedQuery(name = "UserMaster.findByMacAdr", query = "SELECT u FROM UserMaster u WHERE u.macAdr = :macAdr"),
    @NamedQuery(name = "UserMaster.findByDevToken", query = "SELECT u FROM UserMaster u WHERE u.devToken = :devToken"),
    @NamedQuery(name = "UserMaster.findByRegID", query = "SELECT u FROM UserMaster u WHERE u.regID = :regID"),
    @NamedQuery(name = "UserMaster.findByRegisterDate", query = "SELECT u FROM UserMaster u WHERE u.registerDate = :registerDate"),
    @NamedQuery(name = "UserMaster.findByNickName", query = "SELECT u FROM UserMaster u WHERE u.nickName = :nickName"),
    @NamedQuery(name = "UserMaster.findByImagePath", query = "SELECT u FROM UserMaster u WHERE u.imagePath = :imagePath"),
    @NamedQuery(name = "UserMaster.findByPrefecture", query = "SELECT u FROM UserMaster u WHERE u.prefecture = :prefecture"),
    @NamedQuery(name = "UserMaster.findByIntroduction", query = "SELECT u FROM UserMaster u WHERE u.introduction = :introduction"),
    @NamedQuery(name = "UserMaster.findByRoute", query = "SELECT u FROM UserMaster u WHERE u.route = :route")})
public class UserMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "TwitterID")
    private String twitterID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "TwitterAccessToken")
    private String twitterAccessToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "MacAdr")
    private String macAdr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DevToken")
    private String devToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "RegID")
    private String regID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegisterDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NickName")
    private String nickName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ImagePath")
    private String imagePath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "prefecture")
    private String prefecture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "introduction")
    private String introduction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Route")
    private String route;

    public UserMaster() {
    }

    public UserMaster(Integer userID) {
        this.userID = userID;
    }

    public UserMaster(Integer userID, String twitterID, String twitterAccessToken, String macAdr, String devToken, String regID, Date registerDate, String nickName, String imagePath, String prefecture, String introduction, String route) {
        this.userID = userID;
        this.twitterID = twitterID;
        this.twitterAccessToken = twitterAccessToken;
        this.macAdr = macAdr;
        this.devToken = devToken;
        this.regID = regID;
        this.registerDate = registerDate;
        this.nickName = nickName;
        this.imagePath = imagePath;
        this.prefecture = prefecture;
        this.introduction = introduction;
        this.route = route;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTwitterID() {
        return twitterID;
    }

    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }

    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }

    public void setTwitterAccessToken(String twitterAccessToken) {
        this.twitterAccessToken = twitterAccessToken;
    }

    public String getMacAdr() {
        return macAdr;
    }

    public void setMacAdr(String macAdr) {
        this.macAdr = macAdr;
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
