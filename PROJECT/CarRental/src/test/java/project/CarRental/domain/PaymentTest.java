package project.CarRental.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testSetAndGetId() {
        Payment payment = new Payment();
        payment.setId(1L);
        assertEquals(1L, payment.getId());
    }

    @Test
    public void testSetAndGetType() {
        Payment payment = new Payment();
        payment.setType("Credit Card");
        assertEquals("Credit Card", payment.getType());
    }

    @Test
    public void testSetAndGetAmount() {
        Payment payment = new Payment();
        payment.setAmount(100.0);
        assertEquals(100.0, payment.getAmount());
    }

    @Test
    public void testSetAndGetRental() {
        Payment payment = new Payment();
        Rental rental = new Rental();
        payment.setRental(rental);
        assertEquals(rental, payment.getRental());
    }
}