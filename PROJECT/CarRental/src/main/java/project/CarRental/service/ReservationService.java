package project.CarRental.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import project.CarRental.config.RentalConfiguration;
import project.CarRental.domain.Customer;
import project.CarRental.domain.Reservation;
import project.CarRental.repository.CustomerRepository;
import project.CarRental.repository.ReservationRepository;

import java.time.LocalDate;

@Service
@EnableJms
public class ReservationService {

    Logger logger = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RentalConfiguration configuration;


    public ReservationDTO createReservation(Long customerNumber, String startDate, String endDate, Long carId) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber).get();
        System.out.println(configuration.getMaxReservationsPerCustomer());
        System.out.println(customer.getReservations().size());
        if(customer.getReservations().size() > configuration.getMaxReservationsPerCustomer()) {
            System.out.println("##############################");
            System.out.println("##############################");
            System.out.println("##############################");
            System.out.println("max reservations size exceeded");
            logger.warn("max reservations size exceeded");
            System.out.println("##############################");
            System.out.println("##############################");
            System.out.println("##############################");
        }
        Reservation reservation = Reservation.builder().customer(customer).startDate(startDate).endDate(endDate).carId(carId).build();
        reservationRepository.save(reservation);
        System.out.println("sending reservation " + Long.toString(carId));
        jmsTemplate.convertAndSend("reservation", Long.toString(carId));
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    public void informLowAvailability(String message) {
        System.out.println(message);
        logger.warn(message);
    }

}