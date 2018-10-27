package pl.gda.pg.eti.kask.javaee.jsf.api.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.BandService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Member;

import javax.ws.rs.ext.Provider;

@Provider
public class MemberConverter extends AbstractEntityConverter<Member> {

    public MemberConverter() {
        super(Member.class, Member::getId, BandService::findMember);
    }
}
