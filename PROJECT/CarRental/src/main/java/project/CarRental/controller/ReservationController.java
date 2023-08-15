package project.CarRental.controller;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.CarRental.service.ReservationDTO;
import project.CarRental.service.ReservationService;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    // @Autowired
    // private ModelMapper modelMapper;

    @PostMapping("/reservations")
    public ResponseEntity<?> createReservation(@RequestParam("customerNumber") Long customerNumber,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("carId") String carId) {
        ReservationDTO reservation = reservationService.createReservation(customerNumber, startDate, endDate,
                Long.parseLong(carId));
        return new ResponseEntity<ReservationDTO>(reservation, HttpStatus.OK);
    }
}
