package api.akdenizhwgrup.MLS.account;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.akdenizhwgrup.MLS.card.AccountCard;
import api.akdenizhwgrup.MLS.customer.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class CustomerBankAccount {

    @Id
    @GenericGenerator(name = "random-15", strategy = "api.akdenizhwgrup.MLS.util.StringSequenceIdentifier", parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    @OneToMany(mappedBy = "bankaccount", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<AccountCard> accountcard;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

}
