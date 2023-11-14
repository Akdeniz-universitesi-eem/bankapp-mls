package api.akdenizhwgrup.MLS.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.akdenizhwgrup.MLS.customer.Customer;
import api.akdenizhwgrup.MLS.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Page<Customer> getAllAsPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public void delete(String id) {
        Customer customerInDB = this.getById(id);
        if (customerInDB == null) {
            System.out.println("No such customer");
        }
        customerRepository.delete(customerInDB);
    }

}
