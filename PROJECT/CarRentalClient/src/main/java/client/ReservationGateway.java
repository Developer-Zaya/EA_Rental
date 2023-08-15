package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReservationGateway {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RentalConfiguration configuration;

    public ReservationDTO createReservation(Long customerNumber, LocalDate startDate, LocalDate endDate, Long carId) {
        ReservationDTO reservationDTO = restTemplate.postForObject(configuration.getServerUrl() + "/reservations/?customerNumber={customerNumber}&startDate={startDate}&endDate={endDate}&carId={carId}", null, ReservationDTO.class, customerNumber, startDate, endDate, carId);
        return reservationDTO;
    }
}