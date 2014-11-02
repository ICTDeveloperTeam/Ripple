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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YusukeKato
 */
@Entity
@Table(name = "LoginInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginInfo.findAll", query = "SELECT l FROM LoginInfo l"),
    @NamedQuery(name = "LoginInfo.findByLogID", query = "SELECT l FROM LoginInfo l WHERE l.logID = :logID"),
    @NamedQuery(name = "LoginInfo.findByLoginDate", query = "SELECT l FROM LoginInfo l WHERE l.loginDate = :loginDate"),
    @NamedQuery(name = "LoginInfo.findByLogoutDate", query = "SELECT l FROM LoginInfo l WHERE l.logoutDate = :logoutDate"),
    @NamedQuery(name = "LoginInfo.findByUserID", query = "SELECT l FROM LoginInfo l WHERE l.userID = :userID")})
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LogID")
    private Integer logID;
    @Column(name = "LoginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    @Column(name = "LogoutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutDate;
    @Column(name = "UserID")
    private Integer userID;

    public LoginInfo() {
    }

    public LoginInfo(Integer logID) {
        this.logID = logID;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logID != null ? logID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginInfo)) {
            return false;
        }
        LoginInfo other = (LoginInfo) object;
        if ((this.logID == null && other.logID != null) || (this.logID != null && !this.logID.equals(other.logID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LoginInfo[ logID=" + logID + " ]";
    }
    
}
