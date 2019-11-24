package jakarta.nosql.demo;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("users")
public class UserResource {

    private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    @Inject
    private UserRepository repository;


    @Path("{nickname}")
    @GET
    public User find(@PathParam("nickname") String nickname) {
        return repository.findById(nickname)
                .orElseThrow(() -> new WebApplicationException("User does not find",
                        Response.Status.NOT_FOUND));
    }

    @POST
    public User insert(User user) {
        LOGGER.info("insert: " + user);
        return repository.save(user);
    }


    @Path("{nickname}")
    @GET
    public User update(@PathParam("nickname") String nickname, User newUser) {
        User user = repository.findById(nickname)
                .orElseThrow(() -> new WebApplicationException("User does not find",
                        Response.Status.NOT_FOUND));
        user.update(newUser);
        return repository.save(user);
    }

    @Path("{nickname}")
    @DELETE
    public void delete(@PathParam("nickname") String nickname) {
        repository.deleteById(nickname);
    }
}
