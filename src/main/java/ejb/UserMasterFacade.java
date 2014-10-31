/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.UserMaster;
import entities.service.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author YusukeKato
 */
@Stateless
public class UserMasterFacade extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    UserMaster um;
    Query query;
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserMasterFacade() {
        super(UserMaster.class);
    }
    
    public UserMaster queryByTwitterID(String twitterID){
        query = em.createNamedQuery("UserMaster.findByTwitterID").setParameter("twitterID", twitterID);
        return (UserMaster)query.getSingleResult();    
    }
    
    public String getNickName(String twitterID){
        return queryByTwitterID(twitterID).getNickName();
    }
    
    public void setNickName(String twitterID,String nickName){
        um = queryByTwitterID(twitterID);
        um.setNickName(nickName);
        em.merge(um);
    }
    
    public String getImagePath(String twitterID){
        return queryByTwitterID(twitterID).getImagePath();
    }
    
    public void setImagePath(String twitterID, String imagePath){
        um = queryByTwitterID(twitterID);
        um.setImagePath(imagePath);
        em.merge(um);
    }
    
     public String getPrefecture(String twitterID){
        return queryByTwitterID(twitterID).getImagePath();
    }
    
    public void setPrefecture(String twitterID, String prefecture){
        um = queryByTwitterID(twitterID);
        um.setImagePath(prefecture);
        em.merge(um);
    }
    
    public String getRoute(String twitterID){
        return queryByTwitterID(twitterID).getRoute();
    }
    
    public void setRoute(String twitterID, String Route){
        um = queryByTwitterID(twitterID);
        um.setImagePath(Route);
        em.merge(um);
    }
    
    
}
