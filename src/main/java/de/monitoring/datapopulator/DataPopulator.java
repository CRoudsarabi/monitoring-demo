package de.monitoring.datapopulator;

import de.monitoring.customer.AddCustomerCommand;
import de.monitoring.customer.CustomerAppService;
import org.springframework.stereotype.Component;

@Component
public class DataPopulator {

    private CustomerAppService customerAppService;


    public DataPopulator(CustomerAppService customerAppService) {
        customerAppService.createCustomer(new AddCustomerCommand("Rüdiger", "rüdiger@andrena.de"));
        customerAppService.createCustomer(new AddCustomerCommand("Herbert", "herbert@andrena.de"));
        customerAppService.createCustomer(new AddCustomerCommand("Natalie", "natalie@andrena.de"));
        customerAppService.createCustomer(new AddCustomerCommand("Lea", "lea@andrena.de"));
    }
}
