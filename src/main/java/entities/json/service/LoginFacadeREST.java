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
@Path("entities.json.pojo.login")
public class LoginFacadeREST extends AbstractFacade<LoginInfo> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private LoginInfo loginInfo;
    private Query query;
    private Login login;
    
    
    public LoginFacadeREST() {
        super(LoginInfo.class);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Login entity) {
        entity.getTwitterAccessToken();
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        um=(UserMaster)query.getSingleResult();
        int userId=um.getUserID();
        loginInfo.setUserID(userId);
        super.create(loginInfo);
    }
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Login entity) {
        entity.getTwitterAccessToken();
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", entity.getMacAdr());
        um=(UserMaster)query.getSingleResult();
        int userId=um.getUserID();
        loginInfo.setUserID(userId);
        loginInfo.setLogoutDate(new Date());
        super.edit(loginInfo);
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public LoginInfo find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<LoginInfo> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<LoginInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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