package de.monitoring.customer.io.persistence;

import de.monitoring.customer.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SpringCustomerRepository extends Repository<Customer, Long> {

    List<Customer> getAllBy();

    Customer save(Customer customer);

}
