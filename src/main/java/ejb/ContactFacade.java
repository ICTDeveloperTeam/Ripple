/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ejb;

import entities.Contact;
import entities.UserMaster;
import entities.service.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author まゆ
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    Query query;
    
    UserMaster um;
    List<UserMaster> umList;
    List<Contact> contact;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ContactFacade() {
        super(Contact.class);
    }
    
    public List<UserMaster> getContactInfo(String twitterID){
        query = em.createNamedQuery("UserMaster.findByTwitterID").setParameter("twitterID", twitterID);//UserMasterからUser情報をすべてとってくるクエリを飛ばしている
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            query = em.createNamedQuery("Contact.findByUserID").setParameter("userID", um.getUserID());
            if(!query.getResultList().isEmpty()){
                contact=query.getResultList();
                for(Contact cont : contact){
                    query = em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getReceiveUID());
                    if(!query.getResultList().isEmpty()){
                        um=(UserMaster)query.getSingleResult();
                        umList.add(um);
                    }
                }
                return umList;
            }
        }
        return null;
    }
    
    public List<UserMaster>resContactInfo(String twitterID){
        query = em.createNamedQuery("UserMaster.findByTwitterID").setParameter("twitterID", twitterID);//UserMasterからUser情報をすべてとってくるクエリを飛ばしている
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            query = em.createNamedQuery("Contact.findByUserID").setParameter("receiveUID", um.getUserID());
            if(!query.getResultList().isEmpty()){
                contact=query.getResultList();
                for(Contact cont : contact){
                    query = em.createNamedQuery("UserMaster.findByUserID").setParameter("userID", cont.getUserID());
                    if(!query.getResultList().isEmpty()){
                        um=(UserMaster)query.getSingleResult();
                        umList.add(um);
                    }
                }
                return umList;
            }
        }
        return null;
    }
    
}
