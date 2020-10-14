package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.TagKBDao;
import fr.istic.taa.jaxrs.domain.TagKB;
import fr.istic.taa.jaxrs.domain.CardKB;
import fr.istic.taa.jaxrs.domain.ColumnKB;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Path("/Tagkb")
@Produces({"application/json", "application/xml"})
public class TagKBResource {

    private TagKBDao tagKBDao;

    public TagKBResource() {
        tagKBDao = new TagKBDao();
    }

    @GET
    @Path("/{label}")
    public TagKB getTagKBByLabel(@PathParam("label") String label) {
        return tagKBDao.findByLabel(label);
    }

    @POST
    @Consumes("application/json")
    public Response addTagKB(
            @Parameter(description = "TagKB object that needs to be added to the app", required = true) TagKB tag) {

        for (CardKB card : tag.getCards()) {
            card.addTag(tag);
        }

        tagKBDao.save(tag);

        return Response.ok().entity(tag.getId()).build();
    }
}
