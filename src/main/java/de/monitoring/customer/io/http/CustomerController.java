package de.monitoring.customer.io.http;

import de.monitoring.customer.CustomerAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerAppService customerAppService;

    @Autowired
    private CustomerTOMapper customerTOMapper;

    @GetMapping("/any")
    public CustomerTO getAnyCustomer() {
        return customerTOMapper.mapToTO(customerAppService.getAnyCustomer());
    }

    @GetMapping("/exception")
    public CustomerTO getCustomerThrowsException() {
        return customerTOMapper.mapToTO(customerAppService.getCustomerThrowsException());
    }

    @GetMapping("/repository")
    public List<CustomerTO> getCustomerCallsRepository() {
        return customerTOMapper.mapToTOs(customerAppService.getCustomerCallsRepository());
    }

    @PostMapping
    public CustomerTO createCustomer(@RequestBody AddCustomerCommandTO addCustomerCommandTO) {
        return customerTOMapper.mapToTO(customerAppService.createCustomer(customerTOMapper.mapToEntity(addCustomerCommandTO)));
    }
}
