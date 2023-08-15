package project.CarRental.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class ReservationTest {

    @Test
    public void testSetAndGetStartDate() {
        Reservation reservation = new Reservation();
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        reservation.setStartDate(startDate.toString());
        Assertions.assertEquals(startDate.toString(), reservation.getStartDate());
    }

    @Test
    public void testSetAndGetEndDate() {
        Reservation reservation = new Reservation();
        LocalDate endDate = LocalDate.of(2023, 5, 10);
        reservation.setEndDate(endDate.toString());
        Assertions.assertEquals(endDate.toString(), reservation.getEndDate());
    }

    @Test
    public void testSetAndGetCarId() {
        Reservation reservation = new Reservation();
        Long carId = 12345L;
        reservation.setCarId(carId);
        Assertions.assertEquals(carId, reservation.getCarId());
    }

    @Test
    public void testSetAndGetCustomer() {
        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        customer.setName("John Doe");
        reservation.setCustomer(customer);
        Assertions.assertEquals(customer, reservation.getCustomer());
    }

    @Test
    public void testSetAndGetRental() {
        Reservation reservation = new Reservation();
        Rental rental = new Rental();
        rental.setId(12345L);
        reservation.setRental(rental);
        Assertions.assertEquals(rental, reservation.getRental());
    }
}