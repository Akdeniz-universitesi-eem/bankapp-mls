package api.akdenizhwgrup.MLS.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import api.akdenizhwgrup.MLS.account.CustomerBankAccount;
import api.akdenizhwgrup.MLS.human.Human;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer extends Human {

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerBankAccount customeraccount;
}
