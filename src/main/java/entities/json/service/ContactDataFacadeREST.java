/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.json.service;

import entities.Contact;
import entities.UserMaster;
import entities.json.pojo.ContactData;
import entities.service.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author YusukeKato
 */
@Stateless
@Path("entities.json.pojo.contactdata")
public class ContactDataFacadeREST extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Contact contact;
    private Query query;
    
    public ContactDataFacadeREST() {
        super(Contact.class);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(ContactData entity) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMyMacAdr());
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            contact.setUserID(um.getUserID());
            contact.setContactTypeID(entity.getContactType());
            contact.setMessage(entity.getMessage());
            query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getOtherMacAdr());
            if(!query.getResultList().isEmpty()){
                um=(UserMaster)query.getSingleResult();
                contact.setReceiveUID(um.getUserID());
            }
        }
        /**
         * GCMの処理を書く
         */
        super.create(contact);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
