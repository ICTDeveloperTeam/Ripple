/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.json.service;

import entities.UserMaster;
import entities.json.pojo.Profile;
import entities.json.pojo.ProfileConfig;
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
@Path("entities.json.pojo.profileconfig")
public class ProfileConfigFacadeREST extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;
    private Profile profile;
    private ProfileConfig profileConfig;

    public ProfileConfigFacadeREST() {
        super(UserMaster.class);
    }

    @POST
    @Path("/edit")
    @Consumes({"application/xml", "application/json"})
    public void edit(ProfileConfig entity) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        um=(UserMaster)query.getSingleResult();
       
        super.edit(um);
    }
    
    @POST
    @Path("/create")
    @Consumes({"application/xml", "application/json"})
    public void create(ProfileConfig entity) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        um=(UserMaster)query.getSingleResult();
        super.edit(um);
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
