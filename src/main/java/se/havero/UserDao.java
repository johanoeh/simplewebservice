/**
 * provides basic crud operations to the application
 *
 */
package se.havero;


import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author johan
 */
@ApplicationScoped
public class UserDao {
    
    static final String PU_NAME = "se.havero_USER_PU";
    
    @PersistenceContext(unitName = PU_NAME)
    private EntityManager entityManager;
    
    public UserDao() {

    }
    
    /**
     * persist user to db
     * @param user 
     */
    public void add(User user) {

        entityManager.persist(user);

    }

    /**
     * Gets all saved users if any
     *
     * @return a list of users
     */
    public List<User> get() {
        Query query = entityManager.createNamedQuery(User.USER_ALL);
        List<User> users = (List<User>) query.getResultList();
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
