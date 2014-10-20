/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    @NamedQuery(name = "UserMaster.findByCookie", query = "SELECT u FROM UserMaster u WHERE u.cookie = :cookie"),
    @NamedQuery(name = "UserMaster.findByTwitterID", query = "SELECT u FROM UserMaster u WHERE u.twitterID = :twitterID"),
    @NamedQuery(name = "UserMaster.findByTwitterAccessToken", query = "SELECT u FROM UserMaster u WHERE u.twitterAccessToken = :twitterAccessToken"),
    @NamedQuery(name = "UserMaster.findByUserStatus", query = "SELECT u FROM UserMaster u WHERE u.userStatus = :userStatus"),
    @NamedQuery(name = "UserMaster.findByBtpin", query = "SELECT u FROM UserMaster u WHERE u.btpin = :btpin"),
    @NamedQuery(name = "UserMaster.findByMACAdr", query = "SELECT u FROM UserMaster u WHERE u.mACAdr = :mACAdr"),
    @NamedQuery(name = "UserMaster.findByLenDevToken", query = "SELECT u FROM UserMaster u WHERE u.lenDevToken = :lenDevToken"),
    @NamedQuery(name = "UserMaster.findByDevToken", query = "SELECT u FROM UserMaster u WHERE u.devToken = :devToken"),
    @NamedQuery(name = "UserMaster.findByLenRegID", query = "SELECT u FROM UserMaster u WHERE u.lenRegID = :lenRegID"),
    @NamedQuery(name = "UserMaster.findByRegID", query = "SELECT u FROM UserMaster u WHERE u.regID = :regID"),
    @NamedQuery(name = "UserMaster.findByRegisterDate", query = "SELECT u FROM UserMaster u WHERE u.registerDate = :registerDate"),
    @NamedQuery(name = "UserMaster.findByFirstName", query = "SELECT u FROM UserMaster u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserMaster.findByLastName", query = "SELECT u FROM UserMaster u WHERE u.lastName = :lastName"),
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
    @Size(min = 1, max = 45)
    @Column(name = "Cookie")
    private String cookie;
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
    @Column(name = "UserStatus")
    private int userStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BTPIN")
    private int btpin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "MACAdr")
    private String mACAdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LenDevToken")
    private int lenDevToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "DevToken")
    private String devToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LenRegID")
    private int lenRegID;
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
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "LastName")
    private String lastName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<LoginInfo> loginInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Contact> contactCollection;

    public UserMaster() {
    }

    public UserMaster(Integer userID) {
        this.userID = userID;
    }

    public UserMaster(Integer userID, String cookie, String twitterID, String twitterAccessToken, int userStatus, int btpin, String mACAdr, int lenDevToken, String devToken, int lenRegID, String regID, Date registerDate, String firstName, String lastName, String nickName, String imagePath, String prefecture, String introduction, String route) {
        this.userID = userID;
        this.cookie = cookie;
        this.twitterID = twitterID;
        this.twitterAccessToken = twitterAccessToken;
        this.userStatus = userStatus;
        this.btpin = btpin;
        this.mACAdr = mACAdr;
        this.lenDevToken = lenDevToken;
        this.devToken = devToken;
        this.lenRegID = lenRegID;
        this.regID = regID;
        this.registerDate = registerDate;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
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

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getBtpin() {
        return btpin;
    }

    public void setBtpin(int btpin) {
        this.btpin = btpin;
    }

    public String getMACAdr() {
        return mACAdr;
    }

    public void setMACAdr(String mACAdr) {
        this.mACAdr = mACAdr;
    }

    public int getLenDevToken() {
        return lenDevToken;
    }

    public void setLenDevToken(int lenDevToken) {
        this.lenDevToken = lenDevToken;
    }

    public String getDevToken() {
        return devToken;
    }

    public void setDevToken(String devToken) {
        this.devToken = devToken;
    }

    public int getLenRegID() {
        return lenRegID;
    }

    public void setLenRegID(int lenRegID) {
        this.lenRegID = lenRegID;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @XmlTransient
    @JsonIgnore
    public Collection<LoginInfo> getLoginInfoCollection() {
        return loginInfoCollection;
    }

    public void setLoginInfoCollection(Collection<LoginInfo> loginInfoCollection) {
        this.loginInfoCollection = loginInfoCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
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
