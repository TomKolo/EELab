package pl.gda.pg.eti.kask.javaee.jsf.business.entities;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Band implements Serializable {

    private Integer id;

    private Boolean active;

    private Date dateOfCreation;

    private String name;

    private TypeOfMusic type;

    private List<Member> members = new ArrayList<>();

    private List<Album> albums = new ArrayList<>();

}