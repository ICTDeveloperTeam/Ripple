/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.json.service;

import entities.Contact;
import entities.ContactType;
import entities.UserMaster;
import entities.json.pojo.ContactData;
import entities.service.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    private ContactType contactType;
    private Query query;
    private ContactData contactData;
    
    public ContactDataFacadeREST() {
        super(Contact.class);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(ContactData entity) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMyMacAdr());
        um=(UserMaster)query.getSingleResult();
        contact.setUserID(um.getUserID());
        contact.setContactTypeID(entity.getContactType());
        contact.setMessage(entity.getMessage());
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getOtherMacAdr());
        um=(UserMaster)query.getSingleResult();
        contact.setReceiveUID(um.getUserID());
        /**
         * GCMの処理を書く
         */
        super.create(contact);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Contact entity) {
        super.edit(entity);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Contact find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Contact> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Contact> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
