package project.CarRental.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.CarRental.domain.Customer;
import project.CarRental.dto.WriteCustomerDto;
import project.CarRental.exceptions.Exceptions;
import project.CarRental.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<CustomerDTO> findCustomers(String email, String name) {
        List<Customer> allCustomers;

        if (email.isEmpty() && name.isEmpty()) {
            allCustomers = customerRepository.findAll();
        } else if (!email.isEmpty()) {
            allCustomers = customerRepository.findByEmail(email);
        } else if (!name.isEmpty()) {
            allCustomers = customerRepository.findByName(name);
        } else {
            allCustomers = customerRepository.findByEmailAndName(email, name);
        }

        return allCustomers.stream().map(x -> modelMapper.map(x, CustomerDTO.class)).collect(Collectors.toList());
    }

    public void deleteCustomer(Long customerNumber) {
        Customer customer = getByCustomerNumber(customerNumber);
        customerRepository.delete(customer);
    }

    public Customer getByCustomerNumber(Long customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerNumber(customerNumber);

        if (!optionalCustomer.isPresent()) {
            throw Exceptions.CUSTOMER_MODEL_NOT_FOUND;
        }

        return optionalCustomer.get();
    }

    public CustomerDTO findCustomerByCustomerNumber(Long customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerNumber(customerNumber);

        if (!optionalCustomer.isPresent()) {
            throw Exceptions.CUSTOMER_MODEL_NOT_FOUND;
        }

        return modelMapper.map(optionalCustomer.get(), CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(Long customerNumber, WriteCustomerDto customerDto) {
        Customer customer = getByCustomerNumber(customerNumber);
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customerRepository.save(customer);

        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO createCustomer(WriteCustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer returningCustomer = customerRepository.save(customer);
        return modelMapper.map(returningCustomer, CustomerDTO.class);
    }
}
