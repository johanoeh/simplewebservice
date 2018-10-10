package se.havero;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/userservice")
public class UserService {

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
          UserDao userDao = new UserDao();
        return userDao.get();
    }
    
    @Path("/users")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User addUser(User user){
        UserDao userDao = new UserDao();
        userDao.add(user);
        return user;
    }
}
