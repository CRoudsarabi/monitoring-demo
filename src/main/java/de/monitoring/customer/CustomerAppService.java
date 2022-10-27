package de.monitoring.customer;

import de.monitoring.errorhandling.NotFoundException;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAppService {

    @Autowired
    private Customers customers;


    public Customer createCustomer(AddCustomerCommand command) {
        var customer = new Customer(command.name(), command.email());
        return customers.createCustomer(customer);
    }

    @Timed("customer.service.get.any")
    public Customer getAnyCustomer() {
        doSomeCalculation();
        return new Customer("Herbert", "herbert@andrena.de");
    }

    public Customer getCustomerThrowsException() {
        throw new NotFoundException("Customer not found");
    }

    private void doSomeCalculation() {
        for (int i = 0; i <= 1_000; i++) {
            Math.sqrt(2);
        }
    }

    public List<Customer> getCustomerCallsRepository() {
        return customers.getCustomers();
    }
}
