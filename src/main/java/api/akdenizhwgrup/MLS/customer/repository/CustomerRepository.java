package api.akdenizhwgrup.MLS.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.akdenizhwgrup.MLS.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    
}
