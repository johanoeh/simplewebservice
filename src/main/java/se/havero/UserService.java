package se.havero;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.transaction.Transactional;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/userservice")
@RequestScoped
@Transactional
public class UserService {
    @Inject
    private UserDao userDao;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @Path("/users")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
    public List<User> getUsers() {
        return userDao.get();
    }
    
    @Path("/users")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User addUser(User user){
        userDao.add(user);
        return user;
    }
}
