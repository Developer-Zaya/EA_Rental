package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerGateway {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RentalConfiguration configuration;

    public CustomerDTO createCustomer(String email, String name) {
        CustomerDTO customerDTO = restTemplate.postForObject(configuration.getServerUrl()+"/customers/?email={email}&name={name}", null, CustomerDTO.class, email, name);
        return customerDTO;
    }

    public List<CustomerDTO> getAllCustomers() {
        Customers customers = restTemplate.getForObject(configuration.getServerUrl()+"/customers", Customers.class);
        return customers.getCustomerList();
    }

    public void deleteCustomer(Long customerNumber) {
        restTemplate.delete(configuration.getServerUrl()+"/customers/{customerNumber}", customerNumber);
    }


    public CustomerDTO updateCustomer(Long customerNumber, String email, String name) {
        restTemplate.put(configuration.getServerUrl()+"/customers/{customerNumber}?email={email}&name={name}", null, CustomerDTO.class, customerNumber, email, name);
        return getCustomerByCustomerNumber(customerNumber);
    }

    public CustomerDTO getCustomerByCustomerNumber(Long customerNumber) {
        CustomerDTO customerDTO = restTemplate.getForObject(configuration.getServerUrl()+"/customers/{customerNumber}", CustomerDTO.class, customerNumber);
        return customerDTO;
    }

    public List<CustomerDTO> findCustomer(String email, String name) {
        Customers customers = restTemplate.getForObject(configuration.getServerUrl()+"/customers?email={email}&name={name}", Customers.class, email, name);
        return customers.getCustomerList();
    }

}
