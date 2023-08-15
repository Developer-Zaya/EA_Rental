package project.CarRental.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.CarRental.domain.*;
import project.CarRental.repository.CustomerRepository;
import project.CarRental.repository.EmployeeRepository;
import project.CarRental.repository.PaymentRepository;
import project.CarRental.repository.RentalRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ModelMapper modelMapper;

    public PaymentDTO createPayment(Long id, String type, double amount) {
        Rental rental = rentalRepository.findById(id).get();
        Payment payment = Payment.builder().type(type).amount(amount).rental(rental).build();
        paymentRepository.save(payment);
        rental.setPayment(payment);
        rentalRepository.save(rental);
        return modelMapper.map(payment, PaymentDTO.class);
    }
}