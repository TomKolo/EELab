package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Band;

import javax.ws.rs.ext.Provider;

@Provider
public class BandConverter extends AbstractEntityConverter<Band> {

    public BandConverter() {
        super(Band.class, Band::getId, BandService::findBand);
    }
}
