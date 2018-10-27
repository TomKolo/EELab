package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Album;

import javax.ws.rs.ext.Provider;

@Provider
public class AlbumConverter extends AbstractEntityConverter<Album> {

    public AlbumConverter() {
        super(Album.class, Album::getId, BandService::findAlbum);
    }
}
