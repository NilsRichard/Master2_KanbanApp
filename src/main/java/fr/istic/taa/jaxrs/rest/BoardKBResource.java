package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.BoardKBDao;
import fr.istic.taa.jaxrs.domain.BoardKB;
import fr.istic.taa.jaxrs.domain.CardKB;
import fr.istic.taa.jaxrs.domain.ColumnKB;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Path("/boardkb")
@Produces({"application/json", "application/xml"})
public class BoardKBResource {

    private BoardKBDao boardKBDao;

    public BoardKBResource() {
        boardKBDao = new BoardKBDao();
        boardKBDao.populate();
    }

    @GET
    @Path("/{name}")
    public BoardKB getBoardKBByName(@PathParam("name") String name) {
        return boardKBDao.findByName(name);
    }

    @POST
    @Consumes("application/json")
    public Response addBoardKB(
            @Parameter(description = "BoardKB object that needs to be added to the store", required = true) BoardKB board) {

        for (ColumnKB column : board.getColumns()) {
            column.setBoard(board);
            for (CardKB card : column.getCards()) {
                card.setColumn(column);
            }
        }

        boardKBDao.save(board);

        return Response.ok().entity(board.getId()).build();
    }
}
