package de.monitoring.customer.io.http;

import de.monitoring.customer.CustomerAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/customer")
public class CustomerController {

    @Autowired
    private CustomerAppService customerAppService;

    @Autowired
    private CustomerTOMapper customerTOMapper;

    @PostMapping
    public CustomerTO createCustomer(@RequestBody AddCustomerCommandTO addCustomerCommandTO) {
        return customerTOMapper.mapToTO(customerAppService.createCustomer(customerTOMapper.mapToEntity(addCustomerCommandTO)));
    }
}
