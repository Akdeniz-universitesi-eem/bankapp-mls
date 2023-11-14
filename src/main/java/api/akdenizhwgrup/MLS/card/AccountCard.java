package api.akdenizhwgrup.MLS.card;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.akdenizhwgrup.MLS.account.CustomerBankAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AccountCard {

    @Id
    @GenericGenerator(name = "random-15", strategy = "api.akdenizhwgrup.MLS.util.StringSequenceIdentifier", parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    private String cardno;

    private String expiredate;

    private String cvc;

    private String nameoncard;

    @ManyToOne
    @JoinColumn(name = "bankaccount_id")
    @JsonIgnore
    private CustomerBankAccount bankaccount;

}
