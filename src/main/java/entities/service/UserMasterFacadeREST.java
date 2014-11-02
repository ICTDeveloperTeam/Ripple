/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.UserMaster;
import entities.json.pojo.Profile;
import entities.json.pojo.ProfileConfig;
import java.util.Date;
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
@Path("entities.usermaster")
public class UserMasterFacadeREST extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;

    public UserMasterFacadeREST() {
        super(UserMaster.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(UserMaster entity) {
        super.create(entity);
    }
    
    @POST
    @Path("profileConfig")
    @Consumes({"application/xml", "application/json"})
    public void profileConfig(ProfileConfig entity) {
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

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, UserMaster entity) {
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
    public UserMaster find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/profile/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public Profile profile(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        if(!query.getResultList().isEmpty()){
            Profile profile=new Profile();
            um=(UserMaster)query.getSingleResult();
            profile.setIntroduciton(um.getIntroduction());
            profile.setNickName(um.getIntroduction());
            profile.setPrefecture(um.getPrefecture());
            profile.setRoute(um.getPrefecture());
            profile.setTwitterID(um.getTwitterID());
            profile.setImagePath(um.getImagePath());
            return profile;
        }
        return null;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<UserMaster> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UserMaster> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
