package jakarta.nosql.demo;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
@RequestScoped
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    public String doGet() {
        return "Hello world";
    }
}
