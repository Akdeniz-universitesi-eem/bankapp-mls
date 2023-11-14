package api.akdenizhwgrup.MLS.customer.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCustomerXAction {

    private String name;

    private String email;
}
