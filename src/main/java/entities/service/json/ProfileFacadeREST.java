package entities.json.service;

import entities.UserMaster;
import entities.json.pojo.Profile;
import entities.service.AbstractFacade;
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
@Path("entities.json.pojo.profile")
public class ProfileFacadeREST extends AbstractFacade<UserMaster> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;
    private Profile profile;
    
    public ProfileFacadeREST() {
        super(UserMaster.class);
    }
    
    @GET
    @Path("/{macAdr}")
    @Produces({"application/xml", "application/json"})
    public Profile find(@PathParam("macAdr") String macAdr) {
        query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdr);
        if(!query.getResultList().isEmpty()){
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
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
