package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member implements Serializable {

    private Integer id;

    private Boolean alive;

    private Date dateOfBirth;

    private String name;

    private String surname;

}
