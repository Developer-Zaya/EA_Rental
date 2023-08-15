package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class RentalGateway {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RentalConfiguration configuration;

    public RentalDTO createRental(Long customerNumber, LocalDate startDate, LocalDate endDate, Long carId, Long employeeId, Long reservationId) {
        RentalDTO rentalDTO = restTemplate.postForObject(configuration.getServerUrl() + "/rentals?customerNumber={customerNumber}&startDate={startDate}&endDate={endDate}&carId={carId}&employeeId={employeeId}&reservationId={reservationId}", null, RentalDTO.class, customerNumber, startDate, endDate, carId, employeeId, reservationId);
        return rentalDTO;
    }
    public RentalDTO pickup(Long id, String street, String city, String state, String zip) {
        RentalDTO rentalDTO = restTemplate.postForObject(configuration.getServerUrl() + "/rentals/{id}?operation=pickup&street={street}&city={city}&state={state}&zip={zip}", null, RentalDTO.class, street, city, state, zip);
        return rentalDTO;
    }
    public RentalDTO drop(Long id, String street, String city, String state, String zip) {
        RentalDTO rentalDTO = restTemplate.postForObject(configuration.getServerUrl() + "/rentals/{id}?operation=drop&street={street}&city={city}&state={state}&zip={zip}", null, RentalDTO.class, street, city, state, zip);
        return rentalDTO;
    }
    public PaymentDTO pay(Long id, String type, double amount) {
        PaymentDTO paymentDTO = restTemplate.postForObject(configuration.getServerUrl() + "/rentals/{id}/payments?type={type}&amount={amount}", null, PaymentDTO.class, id, type, amount);
        return paymentDTO;
    }
}