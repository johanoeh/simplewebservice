/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author johan
 */
public class UserDao {

    public UserDao() {
      

    }
    
    /**
     * persist user to db
     * @param user 
     */
    public void add(User user) {

        DAOHelper helper = new DAOHelper(DAOHelper.PU_NAME);
        EntityManager entityManager = helper.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        helper.close();

    }

    /**
     * Gets all saved users if any
     *
     * @return a list of users
     */
    public List<User> get() {

        List<User> users;
        DAOHelper helper = new DAOHelper(DAOHelper.PU_NAME);
        EntityManager emManager = helper.getEntityManager();
        Query query = emManager.createNamedQuery(User.USER_ALL);
        users = (List<User>) query.getResultList();
        helper.close();

        return users;
    }

    /**
     *
     * @param user
     */
    public void update(User user) {

        DAOHelper helper = new DAOHelper(DAOHelper.PU_NAME);
        EntityManager entityManager = helper.getEntityManager();
        entityManager.getTransaction().begin();
        User userToUpdate = entityManager.find(User.class, user.getId());
        //update with new values
        userToUpdate.setPassWord(user.getPassWord());
        userToUpdate.setUserName(user.getUserName());
        //Persist updated User object
        entityManager.persist(userToUpdate);
        entityManager.getTransaction().commit();

    }


}
