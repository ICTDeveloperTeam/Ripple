/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "ContactType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactType.findAll", query = "SELECT c FROM ContactType c"),
    @NamedQuery(name = "ContactType.findByContactTypeID", query = "SELECT c FROM ContactType c WHERE c.contactTypeID = :contactTypeID"),
    @NamedQuery(name = "ContactType.findByType", query = "SELECT c FROM ContactType c WHERE c.type = :type")})
public class ContactType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContactTypeID")
    private Integer contactTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactTypeID")
    private Collection<Contact> contactCollection;

    public ContactType() {
    }

    public ContactType(Integer contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public ContactType(Integer contactTypeID, String type) {
        this.contactTypeID = contactTypeID;
        this.type = type;
    }

    public Integer getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(Integer contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (contactTypeID != null ? contactTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactType)) {
            return false;
        }
        ContactType other = (ContactType) object;
        if ((this.contactTypeID == null && other.contactTypeID != null) || (this.contactTypeID != null && !this.contactTypeID.equals(other.contactTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ContactType[ contactTypeID=" + contactTypeID + " ]";
    }
    
}
