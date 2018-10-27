package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Band;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.*;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

@Path("/bands")
public class BandsController {

    @Inject
    BandService bandService;

    @GET
    public Collection<Band> getAllBands() {
        return bandService.findAllBands();
    }

    @GET
    @Path("/{band}")
    public Band getBand(@PathParam("band") Band band) {
        return band;
    }

    @POST
    public Response saveBand(Band band) {
        bandService.saveBand(band);
        return created(uri(BandsController.class, "getBand", band.getId())).build();
    }

    @DELETE
    @Path("/{band}")
    public Response deleteBand(@PathParam("band") Band band) {
        bandService.removeBand(band);
        return noContent().build();
    }

    @PUT
    @Path("/{band}")
    public Response updateBand(@PathParam("band") Band originalBand, Band updatedBand) {
        if (!originalBand.getId().equals(updatedBand.getId())) {
            return status(Response.Status.BAD_REQUEST).build();
        }

        bandService.saveBand(updatedBand);
        return ok().build();
    }
}
