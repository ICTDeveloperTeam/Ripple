/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.service;

import entities.Contact;
import entities.UserMaster;
import entities.json.pojo.History;
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
@Path("entities.history")
public class HistoryFacadeREST{
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private Query query;
    private UserMaster um;
    private List<Contact> contact;
    private History history;
    private List<History> historyList;
    
    public HistoryFacadeREST() {
    }
    
    @GET
    @Path("/sent/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public List<History> sent(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        if(!query.getResultList().isEmpty()){
            um = (UserMaster)query.getSingleResult();
            query = em.createNamedQuery("Contact.findByUserID").setParameter("userID", um.getUserID());
            if(!query.getResultList().isEmpty()){
                contact=query.getResultList();
                for(Contact cont : contact){
                    query=em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getReceiveUID());
                    if(!query.getResultList().isEmpty()){
                        um=(UserMaster)query.getSingleResult();
                        history.setContactType(cont.getContactTypeID());
                        history.setImagePath(um.getImagePath());
                        history.setMessage(cont.getMessage());
                        history.setNickName(um.getNickName());
                        history.setOtherMacAdr(um.getMacAdr());
                        history.setTwitterID(um.getTwitterID());
                        historyList.add(history);
                    }
                }
                if(!historyList.isEmpty()){
                    return historyList;
                }
            }
        }
        return null;
    }
    
    @GET
    @Path("/receive/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public List<History> receive(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        if(!query.getResultList().isEmpty()){
            um = (UserMaster)query.getSingleResult();
            query = em.createNamedQuery("Contact.findByUserID").setParameter("receiveUID", um.getUserID());
            if(!query.getResultList().isEmpty()){
                contact=query.getResultList();
                for(Contact cont : contact){
                    query=em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getUserID());
                    if(!query.getResultList().isEmpty()){
                        um=(UserMaster)query.getSingleResult();
                        history.setContactType(cont.getContactTypeID());
                        history.setImagePath(um.getImagePath());
                        history.setMessage(cont.getMessage());
                        history.setNickName(um.getNickName());
                        history.setOtherMacAdr(um.getMacAdr());
                        history.setTwitterID(um.getTwitterID());
                        historyList.add(history);
                    }
                }
                if(!historyList.isEmpty()){
                    return historyList;
                }
            }
        }
        return null;
    }

}
