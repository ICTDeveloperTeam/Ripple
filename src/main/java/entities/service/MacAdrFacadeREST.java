/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package entities.service;

import entities.UserMaster;
import entities.json.pojo.MacAdr;
import entities.json.pojo.PeopleAround;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author YusukeKato
 */
@Stateless
@Path("entities.macadr")
public class MacAdrFacadeREST{
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private UserMaster um;
    private Query query;
    
    public MacAdrFacadeREST() {
    }
    
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<PeopleAround> create(MacAdr entity) {
        List<String> macAdrList = entity.getOtherMacAdr();
        List<PeopleAround> profileList = new ArrayList();
        for(String macAdrString : macAdrList){
            query = em.createNamedQuery("UserMaster.findByMacAdr").setParameter("macAdr", macAdrString);
            if(!query.getResultList().isEmpty()){
                PeopleAround peopleAround =new PeopleAround();
                um=(UserMaster)query.getSingleResult();
                peopleAround.setOtherMacAdr(macAdrString);
                peopleAround.setIntroduction(um.getIntroduction());
                peopleAround.setNickName(um.getNickName());
                peopleAround.setPrefecture(um.getPrefecture());
                peopleAround.setRoute(um.getRoute());
                peopleAround.setTwitterID(um.getTwitterID());
                peopleAround.setImagePath(um.getImagePath());
                profileList.add(peopleAround);
            }
        }
        if(!profileList.isEmpty()){
            return profileList;
        }
        return null;
    }
}
