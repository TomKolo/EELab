package pl.gda.pg.eti.kask.javaee.jsf.api;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Album;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.Response.*;
import static pl.gda.pg.eti.kask.javaee.jsf.api.UriUtils.uri;

@Path("/albums")
public class AlbumsController {

    @Inject
    BandService bandService;

    @GET
    public Collection<Album> getAllAlbums() {
        return bandService.findAllAlbums();
    }

    @GET
    @Path("/{album}")
    public Album getAlbum(@PathParam("album") Album album) {
        return album;
    }

    @POST
    public Response saveAlbum(Album album) {
        bandService.saveAlbum(album);
        return created(uri(AlbumsController.class, "getAlbum", album.getId())).build();
    }

    @DELETE
    @Path("/{album}")
    public Response deleteAlbum(@PathParam("album") Album album) {
        bandService.removeAlbum(album);
        return noContent().build();
    }

    @PUT
    @Path("/{album}")
    public Response updatedAlbum(@PathParam("album") Album originalAlbum, Album updatedAlbum) {
        if (!originalAlbum.getId().equals(updatedAlbum.getId())) {
            return status(Response.Status.BAD_REQUEST).build();
        }

        bandService.saveAlbum(updatedAlbum);
        return ok().build();
    }
}
