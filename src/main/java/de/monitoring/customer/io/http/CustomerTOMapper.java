package de.monitoring.customer.io.http;

import de.monitoring.customer.AddCustomerCommand;
import de.monitoring.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerTOMapper {

    public AddCustomerCommand mapToEntity(AddCustomerCommandTO addCustomerCommandTO) {
        return new AddCustomerCommand(addCustomerCommandTO.name(), addCustomerCommandTO.email());
    }

    public CustomerTO mapToTO(Customer customer) {
        return new CustomerTO(customer.getId(), customer.getName(), customer.getEmail());
    }
}
