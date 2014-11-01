/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.json.service;

import entities.UserMaster;
import entities.json.pojo.ProfileConfig;
import entities.service.AbstractFacade;
import java.util.Date;
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
@Path("entities.json.pojo.profileconfig")
public class ProfileConfigFacadeREST extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;
    
    public ProfileConfigFacadeREST() {
        super(UserMaster.class);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(ProfileConfig entity) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            um.setTwitterID(entity.getTwitterID());
            um.setTwitterAccessToken(entity.getTwitterAccessToken());
            um.setMacAdr(entity.getMacAdr());
            um.setRegID(entity.getRegID());
            um.setNickName(entity.getNickName());
            um.setPrefecture(entity.getPrefecture());
            um.setIntroduction(entity.getIntroduction());
            um.setRoute(entity.getRoute());
            super.edit(um);
        }else{
            um.setTwitterID(entity.getTwitterID());
            um.setTwitterAccessToken(entity.getTwitterAccessToken());
            um.setMacAdr(entity.getMacAdr());
            um.setRegID(entity.getRegID());
            um.setNickName(entity.getNickName());
            um.setPrefecture(entity.getPrefecture());
            um.setIntroduction(entity.getIntroduction());
            um.setRoute(entity.getRoute());
            um.setRegisterDate(new Date());
            super.create(um);
        }
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
