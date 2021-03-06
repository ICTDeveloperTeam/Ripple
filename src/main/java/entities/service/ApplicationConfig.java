/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author YusukeKato
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entities.service.ContactFacadeREST.class);
        resources.add(entities.service.ContactTypeFacadeREST.class);
        resources.add(entities.service.HistoryFacadeREST.class);
        resources.add(entities.service.LoginInfoFacadeREST.class);
        resources.add(entities.service.MacAdrFacadeREST.class);
        resources.add(entities.service.UserMasterFacadeREST.class);
    }
    
}
