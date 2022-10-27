package de.monitoring.customer.io.http;

import de.monitoring.customer.AddCustomerCommand;
import de.monitoring.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTOMapper {

    public List<CustomerTO> mapToTOs(List<Customer> customers) {
        return customers.stream().map(this::mapToTO).toList();
    }

    public CustomerTO mapToTO(Customer customer) {
        return new CustomerTO(customer.getId(), customer.getName(), customer.getEmail());
    }

    public AddCustomerCommand mapToEntity(AddCustomerCommandTO addCustomerCommandTO) {
        return new AddCustomerCommand(addCustomerCommandTO.name(), addCustomerCommandTO.email());
    }
}
