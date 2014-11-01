/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.json.service;

import entities.LoginInfo;
import entities.UserMaster;
import entities.json.pojo.Login;
import entities.service.AbstractFacade;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author YusukeKato
 */
@Stateless
@Path("entities.json.pojo.login")
public class LoginFacadeREST extends AbstractFacade<LoginInfo> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private LoginInfo loginInfo;
    private Query query;
    
    
    public LoginFacadeREST() {
        super(LoginInfo.class);
    }
    
    @POST
    @Path("/create")
    @Consumes({"application/xml", "application/json"})
    public void create(Login entity) {
        entity.getTwitterAccessToken();
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            loginInfo.setUserID(um.getUserID());
            loginInfo.setLoginDate(new Date());
            super.create(loginInfo);
        }
    }

    @POST
    @Path("/edit")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Login entity) {
        entity.getTwitterAccessToken();
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        if(!query.getResultList().isEmpty()){
            um=(UserMaster)query.getSingleResult();
            loginInfo.setUserID(um.getUserID());
            loginInfo.setLogoutDate(new Date());
            super.edit(loginInfo);
        }
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
