package jakarta.nosql.demo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.function.Supplier;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("heroes")
public class HeroResources {

    private static final Supplier<WebApplicationException> NOT_FOUND = () -> new WebApplicationException("Hero does not find",
            Response.Status.NOT_FOUND);

    @Inject
    private HeroRepository repository;

    @GET
    public List<Hero> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Hero find(@PathParam("id") String id) {
        return repository.findById(id)
                .orElseThrow(NOT_FOUND);
    }

    @POST
    public Hero insert(Hero hero) {
        return repository.save(hero);
    }


    @Path("{id}")
    @PUT
    public Hero update(@PathParam("id") String id, Hero heroUpdated) {
        Hero user = repository.findById(id)
                .orElseThrow(NOT_FOUND);
        user.update(heroUpdated);
        return repository.save(user);
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") String id) {
        repository.deleteById(id);
    }
}
