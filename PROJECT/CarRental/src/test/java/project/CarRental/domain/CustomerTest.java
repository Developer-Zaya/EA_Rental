package project.CarRental.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testSetAndGetCustomerNumber() {
        Customer customer = new Customer();
        customer.setCustomerNumber(1L);
        assertEquals(1L, customer.getCustomerNumber());
    }

    @Test
    public void testSetAndGetName() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testSetAndGetEmail() {
        Customer customer = new Customer();
        customer.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", customer.getEmail());
    }

    @Test
    public void testSetAndGetReservations() {
        Customer customer = new Customer();
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation1);
        reservations.add(reservation2);
        customer.setReservations(reservations);
        assertEquals(reservations, customer.getReservations());
    }

    @Test
    public void testSetAndGetRentals() {
        Customer customer = new Customer();
        Rental rental1 = new Rental();
        Rental rental2 = new Rental();
        List<Rental> rentals = new ArrayList<>();
        rentals.add(rental1);
        rentals.add(rental2);
        customer.setRentals(rentals);
        assertEquals(rentals, customer.getRentals());
    }
}
