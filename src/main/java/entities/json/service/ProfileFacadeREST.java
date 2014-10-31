/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.json.service;

import entities.UserMaster;
import entities.json.pojo.Profile;
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
@Path("entities.json.pojo.profile")
public class ProfileFacadeREST extends AbstractFacade<Profile> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;
    private Profile profile;

    public ProfileFacadeREST() {
        super(Profile.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Profile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Profile entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("findByMacAdr/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public Profile find(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        um=(UserMaster)query.getSingleResult();
        profile.setIntroduciton(um.getIntroduction());
        profile.setNickName(um.getIntroduction());
        profile.setPrefecture(um.getPrefecture());
        profile.setRoute(um.getPrefecture());
        profile.setTwitterID(um.getTwitterID());
        return profile;
    }
    
    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Profile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Profile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
