package pl.gda.pg.eti.kask.javaee.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Album;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class EditAlbum implements Serializable {

    @Inject
    private BandService bandService;

    @Getter
    @Setter
    private Album album = new Album();

    public String saveAlbum() {
        bandService.saveAlbum(album);
        return "list_albums?faces-redirect=true";
    }
}
