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
@Table(name = "Contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactID", query = "SELECT c FROM Contact c WHERE c.contactID = :contactID"),
    @NamedQuery(name = "Contact.findByUserID", query = "SELECT c FROM Contact c WHERE c.userID = :userID"),
    @NamedQuery(name = "Contact.findByReceiveUID", query = "SELECT c FROM Contact c WHERE c.receiveUID = :receiveUID"),
    @NamedQuery(name = "Contact.findByRefreshDate", query = "SELECT c FROM Contact c WHERE c.refreshDate = :refreshDate"),
    @NamedQuery(name = "Contact.findByContactTypeID", query = "SELECT c FROM Contact c WHERE c.contactTypeID = :contactTypeID"),
    @NamedQuery(name = "Contact.findByMessage", query = "SELECT c FROM Contact c WHERE c.message = :message")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContactID")
    private Integer contactID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID")
    private int userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReceiveUID")
    private int receiveUID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RefreshDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date refreshDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactTypeID")
    private int contactTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Message")
    private String message;

    public Contact() {
    }

    public Contact(Integer contactID) {
        this.contactID = contactID;
    }

    public Contact(Integer contactID, int userID, int receiveUID, Date refreshDate, int contactTypeID, String message) {
        this.contactID = contactID;
        this.userID = userID;
        this.receiveUID = receiveUID;
        this.refreshDate = refreshDate;
        this.contactTypeID = contactTypeID;
        this.message = message;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getReceiveUID() {
        return receiveUID;
    }

    public void setReceiveUID(int receiveUID) {
        this.receiveUID = receiveUID;
    }

    public Date getRefreshDate() {
        return refreshDate;
    }

    public void setRefreshDate(Date refreshDate) {
        this.refreshDate = refreshDate;
    }

    public int getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(int contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contact[ contactID=" + contactID + " ]";
    }
    
}
