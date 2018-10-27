package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Album implements Serializable {

    private Integer id;

    private String name;

    private Date dateOfRelease;

    private int soldCopies;

}
