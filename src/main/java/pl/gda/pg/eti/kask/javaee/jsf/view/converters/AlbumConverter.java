package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Album;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Album.class, managed = true)
@Dependent
public class AlbumConverter extends AbstractEntityConverter<Album> {

    public AlbumConverter() {
        super(Album::getId, BandService::findAlbum);
    }
}
