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
import entities.json.pojo.History;
import entities.service.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author YusukeKato
 */
@Stateless
@Path("entities.json.pojo.history")
public class HistoryFacadeREST extends AbstractFacade<History> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private List<UserMaster> umList;
    private List<Contact> contact;
    private ContactType contactType;
    private Query query;
    private ContactData contactData;
    private History history;
    private List<History> historyList;
    
    public HistoryFacadeREST() {
        super(History.class);
    }


    @GET
    @Path("/sent/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public List<History> sent(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        um = (UserMaster)query.getSingleResult();
        query = em.createNamedQuery("Contact.findByUserID").setParameter("userID", um.getUserID());
        contact=query.getResultList();
        for(Contact cont : contact){
            query=em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getReceiveUID());
            um=(UserMaster)query.getSingleResult();
            history.setContactType(cont.getContactTypeID());
            history.setImagePath(um.getImagePath());
            history.setMessage(cont.getMessage());
            history.setNickName(um.getNickName());
            history.setOtherMacAdr(um.getMacAdr());
            history.setTwitterID(um.getTwitterID());
            historyList.add(history);
        }
        return historyList;
    }
    
    @GET
    @Path("/receive/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public List<History> receive(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        um = (UserMaster)query.getSingleResult();
        query = em.createNamedQuery("Contact.findByUserID").setParameter("receiveUID", um.getUserID());
        contact=query.getResultList();
        for(Contact cont : contact){
            query=em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getUserID());
            um=(UserMaster)query.getSingleResult();
            history.setContactType(cont.getContactTypeID());
            history.setImagePath(um.getImagePath());
            history.setMessage(cont.getMessage());
            history.setNickName(um.getNickName());
            history.setOtherMacAdr(um.getMacAdr());
            history.setTwitterID(um.getTwitterID());
            historyList.add(history);
        }
        return historyList;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<History> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
