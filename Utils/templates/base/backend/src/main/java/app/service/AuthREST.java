package <%= package.lower %>.<%= project.lower %>.service;


import io.swagger.annotations.Api;
import <%= package.lower %>.<%= project.lower %>.dao.UserDAO;
import <%= package.lower %>.<%= project.lower %>.security.Credentials;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;
import org.demoiselle.jee.security.annotation.Authenticated;

@Api("Auth")
@Path("auth")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AuthREST {

    @Inject
    private UserDAO dao;

    @POST
    public Response login(Credentials credentials) {
        return ok().entity("{\"token\":\"" + dao.login(credentials) + "\"}").build();
    }

    @GET
    @Authenticated
    public Response retoken() {
        return ok().entity("{\"token\":\"" + dao.retoken() + "\"}").build();
    }

}
