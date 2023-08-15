package project.CarRental.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.CarRental.dto.WriteRentalDto;
import project.CarRental.service.PaymentDTO;
import project.CarRental.service.PaymentService;
import project.CarRental.service.RentalDTO;
import project.CarRental.service.RentalService;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;

    @Autowired
    PaymentService paymentService;

    @PostMapping("/rentals")
    public RentalDTO createRental(@Valid @RequestBody WriteRentalDto writeRentalDto) {
        return rentalService.createRental(writeRentalDto);
    }

    @GetMapping("/rentals")
    public ResponseEntity<?> getAllRentals() {
        List<RentalDTO> rentals = rentalService.getAllRentals();
        return new ResponseEntity<List<RentalDTO>>(rentals, HttpStatus.OK);
    }

    @PutMapping("/rentals/{id}")
    public ResponseEntity<?> pickupOrDrop(@PathVariable("id") Long id,
            @RequestParam("operation") String operation,
            @RequestParam("street") String street,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("zip") String zip) {

        if (operation.equals("pickup")) {
            rentalService.pickup(id, street, city, state, zip);
        } else if (operation.equals("drop")) {
            rentalService.drop(id, street, city, state, zip);
        }
        return new ResponseEntity<RentalDTO>(rentalService.getRentalById(id), HttpStatus.OK);
    }

    @PostMapping("/rentals/{id}/payments")
    public ResponseEntity<?> createPayment(@PathVariable("id") Long id,
            @RequestParam("type") String type,
            @RequestParam("amount") double amount) {
        PaymentDTO payment = paymentService.createPayment(id, type, amount);
        return new ResponseEntity<PaymentDTO>(payment, HttpStatus.OK);
    }
}