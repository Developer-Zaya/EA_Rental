package project.CarRental.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalTest {
    @Test
    public void testRentalConstructor() {
        Rental rental = new Rental();
        assertNotNull(rental);
    }

    @Test
    public void testGetAndSetId() {
        Rental rental = new Rental();
        rental.setId(1L);
        assertEquals(1L, rental.getId());
    }

    @Test
    public void testGetAndSetStartDate() {
        Rental rental = new Rental();
        LocalDate startDate = LocalDate.parse("2022-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        rental.setStartDate(startDate);
        assertEquals(startDate, rental.getStartDate());
    }

    @Test
    public void testGetAndSetEndDate() {
        Rental rental = new Rental();
        LocalDate endDate = LocalDate.parse("2022-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertEquals(endDate, rental.getEndDate());
    }

    @Test
    public void testGetAndSetCarId() {
        Rental rental = new Rental();
        rental.setCarId(1L);
        assertEquals(1L, rental.getCarId());
    }

    @Test
    public void testGetAndSetRentalEmployee() {
        Rental rental = new Rental();
        Employee employee = new Employee();
        employee.setName("John");
        rental.setRentalEmployee(employee);
        assertEquals("John", rental.getRentalEmployee().getName());
    }

    @Test
    public void testGetAndSetReservation() {
        Rental rental = new Rental();
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        rental.setReservation(reservation);
        assertEquals(1L, rental.getReservation().getId());
    }

    @Test
    public void testGetAndSetCustomer() {
        Rental rental = new Rental();
        Customer customer = new Customer();
        customer.setName("Alice");
        rental.setCustomer(customer);
        assertEquals("Alice", rental.getCustomer().getName());
    }

    @Test
    public void testGetAndSetPickup() {
        Rental rental = new Rental();
        Address address = new Address();
        address.setCity("New York");
        rental.setPickup(address);
        assertEquals("New York", rental.getPickup().getCity());
    }

    @Test
    public void testGetAndSetDrop() {
        Rental rental = new Rental();
        Address address = new Address();
        address.setCity("Boston");
        rental.setDrop(address);
        assertEquals("Boston", rental.getDrop().getCity());
    }

    @Test
    public void testGetAndSetPayment() {
        Rental rental = new Rental();
        Payment payment = new Payment();
        payment.setType("credit");
        rental.setPayment(payment);
        assertEquals("credit", rental.getPayment().getType());
    }
}
