package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Band;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Band.class, managed = true)
@Dependent
public class BandConverter extends AbstractEntityConverter<Band> {

    public BandConverter() {
        super(Band::getId, BandService::findBand);
    }
}
