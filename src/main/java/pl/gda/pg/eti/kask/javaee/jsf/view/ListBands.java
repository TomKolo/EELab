package pl.gda.pg.eti.kask.javaee.jsf.view;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Band;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListBands implements Serializable {

    @Inject
    private BandService bandService;

    private Collection<Band> bands;

    public Collection<Band> getBands() {
        return bands != null ? bands : (bands = bandService.findAllBands());
    }

    public String removeBand(Band band) {
        bandService.removeBand(band);
        return "list_bands?faces-redirect=true";
    }
}
