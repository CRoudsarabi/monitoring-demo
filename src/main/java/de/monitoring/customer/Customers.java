package de.monitoring.customer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Customers {

    List<Customer> getCustomers();

    Customer createCustomer(Customer customer);
}
