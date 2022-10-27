package de.monitoring.customer.io.persistence;

import de.monitoring.customer.Customer;
import de.monitoring.customer.Customers;
import de.monitoring.micrometer.TimedRepositoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepository implements Customers {

    @Autowired
    private SpringCustomerRepository springCustomerRepository;


    @Override
    @TimedRepositoryMethod
    public List<Customer> getCustomers() {
        return springCustomerRepository.getAllBy();
    }

    @Override
    @TimedRepositoryMethod
    public Customer createCustomer(Customer customer) {
        return springCustomerRepository.save(customer);
    }
}
