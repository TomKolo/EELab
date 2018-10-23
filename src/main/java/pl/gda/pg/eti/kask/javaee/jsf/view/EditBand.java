package pl.gda.pg.eti.kask.javaee.jsf.view;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class EditBand implements Serializable {

    @Inject
    private BandService bandService;

    @Getter
    @Setter
    private Band band = new Band();


    public Collection<Member> getAvailableMembers() {
        return bandService.findAllMembers();
    }
    public Collection<Album> getAvailableAlbums() {
        return bandService.findAllAlbums();
    }

    public Collection<Band.TypeOfMusic> getAvailableTypes() {
        return asList(Band.TypeOfMusic.values());
    }

    public String saveBand() {
        bandService.saveBand(band);
        return "list_bands?faces-redirect=true";
    }
}
