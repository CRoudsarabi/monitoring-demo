package de.monitoring.customer;

import org.springframework.stereotype.Component;

@Component
public interface Customers {
    Customer createCustomer(Customer customer);
}
