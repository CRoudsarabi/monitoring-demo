package de.monitoring.customer.io.persistence;

import de.monitoring.customer.Customer;
import org.springframework.data.repository.Repository;

public interface SpringCustomerRepository extends Repository<Customer, Long> {

    Customer save(Customer customer);

}
