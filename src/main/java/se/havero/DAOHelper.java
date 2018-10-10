/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author johan
 */
public class DAOHelper {
    
    public static final String PU_NAME = "se.havero_USER_PU";
    
    EntityManagerFactory  emFactory;
    EntityManager eManager;

    public DAOHelper(final String persistenceUnit) {      
        this.emFactory = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    
    public EntityManager getEntityManager(){
        eManager = emFactory.createEntityManager();
        return eManager;
    }
    
    public void close(){  
        eManager.close();
        emFactory.close();  
    }
    
}
