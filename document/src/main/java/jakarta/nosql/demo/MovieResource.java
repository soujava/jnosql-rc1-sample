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
@Path("movies")
public class MovieResource {

    private static final Supplier<WebApplicationException> NOT_FOUND = () -> new WebApplicationException("Movie does not find",
            Response.Status.NOT_FOUND);

    @Inject
    private MovieRepository repository;

    @GET
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Movie find(@PathParam("id") String id) {
        return repository.findById(id)
                .orElseThrow(NOT_FOUND);
    }

    @POST
    public Movie insert(Movie user) {
        return repository.save(user);
    }


    @Path("{id}")
    @PUT
    public Movie update(@PathParam("id") String id, Movie newMovie) {
        Movie movie = repository.findById(id)
                .orElseThrow(NOT_FOUND);
        movie.update(newMovie);
        return repository.save(movie);
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") String id) {
        repository.deleteById(id);
    }
}
