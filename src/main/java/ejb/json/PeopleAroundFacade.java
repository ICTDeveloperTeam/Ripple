/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.json;

import entities.json.pojo.PeopleAround;
import entities.service.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author YusukeKato
 */
@Stateless
public class PeopleAroundFacade extends AbstractFacade<PeopleAround> {
    @PersistenceContext(unitName = "jp.ac.u-tokai.ictedu.hacku14.ripple_Ripple_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeopleAroundFacade() {
        super(PeopleAround.class);
    }
    
}