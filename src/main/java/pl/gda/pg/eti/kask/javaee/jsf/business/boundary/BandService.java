package pl.gda.pg.eti.kask.javaee.jsf.business.boundary;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Calendar.FEBRUARY;

@ApplicationScoped
public class BandService implements Serializable {

    private final SortedMap<Integer, Band> bands = new TreeMap<>();

    private final SortedMap<Integer, Member> members = new TreeMap<>();

    private final SortedMap<Integer, Album> albums = new TreeMap<>();

    @PostConstruct
    public void init() {
        Calendar cal = Calendar.getInstance();
        cal.set(2010, FEBRUARY, 24);

        Album doors1 = new Album(1, "Other voices", cal.getTime(), 100);
        Album doors2 = new Album(2, "Full circle", cal.getTime(), 200);
        albums.put(doors1.getId(), doors1);
        albums.put(doors2.getId(), doors2);
        Member member1 = new Member(1, true, cal.getTime(), "Member", "one" );
        Member member2 = new Member(2, true, cal.getTime(), "Member", "two" );
        Member member3 = new Member(3, true, cal.getTime(), "Member", "three" );
        members.put(member1.getId(), member1);
        members.put(member2.getId(), member2);
        members.put(member3.getId(), member3);
        Band band1 = new Band(1, true, new Date(), "the doors", TypeOfMusic.ROCK, asList(member1), asList(doors1, doors2));
        bands.put(band1.getId(), band1);
    }

    public Collection<Band> findAllBands() { return bands.values(); }
    public Collection<Member> findAllMembers() {
        return members.values();
    }
    public Collection<Album> findAllAlbums() { return albums.values(); }

    public Album findAlbum(int id) { return albums.get(id); }
    public Band findBand(int id) {
        return bands.get(id);
    }
    public Member findMember(int id) {
        return members.get(id);
    }

    public void removeBand(Band band) { bands.remove(band.getId()); }
    public void removeAlbum(Album album){ albums.remove(album.getId()); }

    public void saveBand(Band band) {
        if (band.getId() == null) {
            if(bands.isEmpty()){
                band.setId(1);
            }
            else {
                band.setId(bands.lastKey() + 1);
            }
        }
        bands.put(band.getId(), band);
    }
    public void saveAlbum(Album album) {
        if (album.getId() == null) {
            if(albums.isEmpty()){
                album.setId(1);
            }
            else {
                album.setId(albums.lastKey() + 1);
            }
        }

        albums.put(album.getId(), album);
    }

}
