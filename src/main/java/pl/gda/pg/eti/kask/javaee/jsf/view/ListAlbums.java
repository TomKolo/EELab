package pl.gda.pg.eti.kask.javaee.jsf.view;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Album;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListAlbums implements Serializable {

    @Inject
    private BandService bandService;

    private Collection<Album> albums;

    public Collection<Album> getAlbums() {
        return albums != null ? albums : (albums = bandService.findAllAlbums());
    }

    public String removeAlbum(Album album) {
        bandService.removeAlbum(album);
        return "list_albums?faces-redirect=true";
    }
}
