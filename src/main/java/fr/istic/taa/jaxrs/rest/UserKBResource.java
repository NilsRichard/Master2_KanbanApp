package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.UserKBDao;
import fr.istic.taa.jaxrs.domain.UserKB;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Path("/userkb")
@Produces({"application/json", "application/xml"})
public class UserKBResource {

    private UserKBDao userKBDao;

    public UserKBResource() {
        userKBDao = new UserKBDao();
    }

    @GET
    @Path("/{name}")
    public UserKB getUserKBByName(@PathParam("name") String name) {
        return userKBDao.findByName(name);
    }

    @POST
    @Consumes("application/json")
    public Response addUserKB(
            @Parameter(description = "UserKB object that needs to be added to the app", required = true) UserKB user) {

        user.getCard().setAssignedUser(user);

        userKBDao.save(user);

        return Response.ok().entity(user.getId()).build();
    }
}
