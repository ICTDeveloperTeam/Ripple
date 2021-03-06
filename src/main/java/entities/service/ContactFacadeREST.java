/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Contact;
import entities.UserMaster;
import entities.json.pojo.ContactData;
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
@Path("entities.contact")
public class ContactFacadeREST extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Contact contact;
    private Query query;
    
    public ContactFacadeREST() {
        super(Contact.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Contact entity) {
        super.create(entity);
    }
    
    @POST
    @Path("contactData")
    @Consumes({"application/xml", "application/json"})
    public void contactData(ContactData entity) {
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

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Contact entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Contact find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
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
