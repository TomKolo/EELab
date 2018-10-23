package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Member;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Member.class, managed = true)
@Dependent
public class MemberConverter extends AbstractEntityConverter<Member> {

    public MemberConverter() {
        super(Member::getId, BandService::findMember);
    }
}
