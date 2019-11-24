package jakarta.nosql.demo;


import org.eclipse.jnosql.artemis.graph.GraphTemplate;

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
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("animals")
public class MovieResource {

    private static final Supplier<WebApplicationException> NOT_FOUND = () -> new WebApplicationException("Animal does not find",
            Response.Status.NOT_FOUND);

    @Inject
    private AnimalRepository repository;

    @Inject
    private GraphTemplate template;

    @GET
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Animal find(@PathParam("id") Long id) {
        return repository.findById(id)
                .orElseThrow(NOT_FOUND);
    }

    @POST
    public Animal insert(Animal animal) {
        return repository.save(animal);
    }

    @POST
    @Path("{predator}/eats/{predated}")
    public Animal insert(@PathParam("predator") String predator, @PathParam("predated") String predated) {
        Animal predatorAnimal = repository.findByName(predator).orElseThrow(NOT_FOUND);
        Animal predatedAnimal = repository.findByName(predated).orElseThrow(NOT_FOUND);
        template.edge(predatorAnimal, "eats", predatedAnimal);
        return predatorAnimal;
    }

    @Path("{id}")
    @PUT
    public Animal update(@PathParam("id") Long id, Animal newAnimal) {
        Animal animal = repository.findById(id)
                .orElseThrow(NOT_FOUND);
        animal.update(newAnimal);
        return repository.save(animal);
    }

    @Path("{id}")
    @DELETE
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
