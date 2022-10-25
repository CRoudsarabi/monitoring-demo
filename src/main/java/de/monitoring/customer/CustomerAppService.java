package de.monitoring.customer;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAppService {

    @Autowired
    private Customers customers;


    @Timed("create.customer.logic")
    public Customer createCustomer(AddCustomerCommand command) {
        for (int i = 0; i <= 1_000_000; i++) {
            doSomeCalculation();
        }
        var customer = new Customer(command.name(), command.email());
        return customers.createCustomer(customer);
    }

    private void doSomeCalculation() {
    }
}
