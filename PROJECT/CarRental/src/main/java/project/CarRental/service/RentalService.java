package project.CarRental.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.CarRental.domain.*;
import project.CarRental.dto.WriteRentalDto;
import project.CarRental.repository.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ModelMapper modelMapper;

    public RentalDTO createRental(WriteRentalDto rentalDto) {
        Customer customer = customerRepository.findByCustomerNumber(rentalDto.getCustomerNumber()).get();
        Rental rental = new Rental(rentalDto.getStartDate(), rentalDto.getEndDate(), customer, rentalDto.getCarId());

        if (rentalDto.getEmployeeId() != null) {
            Employee employee = employeeRepository.findById(rentalDto.getEmployeeId()).get();
            rental.setRentalEmployee(employee);
        }

        if (rentalDto.getReservationId() != null) {
            Reservation reservation = reservationRepository.findById(rentalDto.getReservationId()).get();
            rental.setReservation(reservation);
        }

        rentalRepository.save(rental);
        return modelMapper.map(rental, RentalDTO.class);
    }

    public RentalDTO pickup(Long id, String street, String city, String state, String zip) {

        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (!rentalOptional.isPresent()) {
            throw new RuntimeException("Rental record not found with id: " + id);
        }
        Rental rental = rentalOptional.get();
        Address address = Address.builder().street(street).city(city).state(state).zip(zip).build();
        addressRepository.save(address);
        rental.setPickup(address);
        rentalRepository.save(rental);
        return modelMapper.map(rental, RentalDTO.class);
    }

    public RentalDTO drop(Long id, String street, String city, String state, String zip) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (!rentalOptional.isPresent()) {
            throw new RuntimeException("Rental record not found with id: " + id);
        }
        Rental rental = rentalOptional.get();
        Address address = Address.builder().street(street).city(city).state(state).zip(zip).build();
        addressRepository.save(address);
        rental.setDrop(address);
        rentalRepository.save(rental);
        return modelMapper.map(rental, RentalDTO.class);
    }

    public List<RentalDTO> getAllRentals() {
        List<Rental> allRentals = rentalRepository.findAll();
        List<RentalDTO> allRentalDTOs = new ArrayList<>();
        for (Rental rent : allRentals) {
            allRentalDTOs.add(modelMapper.map(rent, RentalDTO.class));
        }
        return allRentalDTOs;
    }

    public RentalDTO getRentalById(Long id) {
        Optional<Rental> rentalOptional = rentalRepository.findById(id);
        if (!rentalOptional.isPresent()) {
            throw new RuntimeException("Rental not found: " + id);
        }
        return modelMapper.map(rentalOptional.get(), RentalDTO.class);
    }

    // Optional<Customer> customerOptional =
    // customerRepository.findByCustomerNumber(customerNumber);
    // if(!customerOptional.isPresent()) {
    // throw new RuntimeException("Customer Model not found with customer number: "+
    // customerNumber);
    // }
    // Customer customer = customerOptional.get();
    // customer.setEmail(email);
    // customer.setName(name);
    // customerRepository.save(customer);
    //
    // return modelMapper.map(customer, CustomerDTO.class);
}