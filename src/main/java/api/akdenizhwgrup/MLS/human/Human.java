package api.akdenizhwgrup.MLS.human;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Human {

    @Id
    @GenericGenerator(name = "random-15", strategy = "api.akdenizhwgrup.MLS.util.StringSequenceIdentifier", parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    private String name;

    private String surname;

    private String email;
}
