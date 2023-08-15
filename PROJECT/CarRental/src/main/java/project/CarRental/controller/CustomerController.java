package project.CarRental.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.CarRental.domain.Customer;
import project.CarRental.dto.WriteCustomerDto;
import project.CarRental.service.CustomerDTO;
import project.CarRental.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public CustomerDTO createCustomer(@Valid @RequestBody WriteCustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/{customerNumber}")
    public CustomerDTO updateCustomer(
            @PathVariable("customerNumber") Long customerNumber,
            @Valid @RequestBody WriteCustomerDto customerDto) {

        return customerService.updateCustomer(customerNumber, customerDto);
    }

    @DeleteMapping("/{customerNumber}")
    public void deleteCustomer(@PathVariable("customerNumber") Long customerNumber) {
        customerService.deleteCustomer(customerNumber);
    }

    @GetMapping
    public List<CustomerDTO> findCustomers(
            @RequestParam(name = "email", required = false, defaultValue = "") String email,
            @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        return customerService.findCustomers(email, name);
    }

    @GetMapping("/{customerNumber}")
    public CustomerDTO getCustomer(@PathVariable("customerNumber") Long customerNumber) {
        return customerService.findCustomerByCustomerNumber(customerNumber);
    }
}
