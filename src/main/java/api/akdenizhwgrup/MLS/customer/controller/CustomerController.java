package api.akdenizhwgrup.MLS.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.akdenizhwgrup.MLS.customer.Customer;
import api.akdenizhwgrup.MLS.customer.service.CustomerService;
import api.akdenizhwgrup.MLS.util.GenericApiResponse;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public GenericApiResponse createCustomer(@RequestBody CreateCustomerXAction xAction) {
        Customer customerNew = new Customer();
        customerNew.setName(xAction.getName());
        customerNew.setEmail(xAction.getEmail());

        customerNew = this.customerService.create(customerNew);

        return new GenericApiResponse(200, "Success", "0001#0000", customerNew);
    }

    // GET, POST, PUT, DELETE
    @GetMapping
    public GenericApiResponse getCustomers(Pageable pageable) {
        Page<Customer> customersPage = this.customerService.getAllAsPage(pageable);
        return new GenericApiResponse(200, "Success", "0001#0001", customersPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getCustomerById(@PathVariable String id) {
        Customer customerInDB = this.customerService.getById(id);
        if (customerInDB == null) {
            return new GenericApiResponse(404, "Fail", "0001#0002", "No Such Customer");
        }
        return new GenericApiResponse(200, "Success", "0001#0003", customerInDB);
    }
}
