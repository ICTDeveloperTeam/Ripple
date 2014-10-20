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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LoginInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginInfo.findAll", query = "SELECT l FROM LoginInfo l"),
    @NamedQuery(name = "LoginInfo.findByLogID", query = "SELECT l FROM LoginInfo l WHERE l.logID = :logID"),
    @NamedQuery(name = "LoginInfo.findByIPv4", query = "SELECT l FROM LoginInfo l WHERE l.iPv4 = :iPv4"),
    @NamedQuery(name = "LoginInfo.findByIPv6", query = "SELECT l FROM LoginInfo l WHERE l.iPv6 = :iPv6"),
    @NamedQuery(name = "LoginInfo.findByLoginDate", query = "SELECT l FROM LoginInfo l WHERE l.loginDate = :loginDate"),
    @NamedQuery(name = "LoginInfo.findByLogoutDate", query = "SELECT l FROM LoginInfo l WHERE l.logoutDate = :logoutDate")})
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LogID")
    private Integer logID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IPv4")
    private String iPv4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "IPv6")
    private String iPv6;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LoginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LogoutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutDate;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private UserMaster userID;

    public LoginInfo() {
    }

    public LoginInfo(Integer logID) {
        this.logID = logID;
    }

    public LoginInfo(Integer logID, String iPv4, String iPv6, Date loginDate, Date logoutDate) {
        this.logID = logID;
        this.iPv4 = iPv4;
        this.iPv6 = iPv6;
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
    }

    public Integer getLogID() {
        return logID;
    }

    public void setLogID(Integer logID) {
        this.logID = logID;
    }

    public String getIPv4() {
        return iPv4;
    }

    public void setIPv4(String iPv4) {
        this.iPv4 = iPv4;
    }

    public String getIPv6() {
        return iPv6;
    }

    public void setIPv6(String iPv6) {
        this.iPv6 = iPv6;
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

    public UserMaster getUserID() {
        return userID;
    }

    public void setUserID(UserMaster userID) {
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
