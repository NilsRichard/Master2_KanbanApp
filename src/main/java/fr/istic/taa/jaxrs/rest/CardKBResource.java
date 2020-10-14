package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.CardKBDao;
import fr.istic.taa.jaxrs.domain.CardKB;
import fr.istic.taa.jaxrs.domain.TagKB;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Path("/cardkb")
@Produces({"application/json", "application/xml"})
public class CardKBResource {

    private CardKBDao cardKBDao;

    public CardKBResource() {
        cardKBDao = new CardKBDao();
        cardKBDao.populate();
    }

    @GET
    @Path("/{label}")
    public List<CardKB> getCardKBLabelLike(@PathParam("label") String label) {
        return cardKBDao.findLabelLike(label);
    }

    @POST
    @Consumes("application/json")
    public Response addCardKB(
            @Parameter(description = "CardKB object that needs to be added to the app", required = true) CardKB card) {

        for (TagKB tag : card.getTags()) {
            tag.addCards(card);
        }

        cardKBDao.save(card);

        return Response.ok().entity(card.getId()).build();
    }
}
