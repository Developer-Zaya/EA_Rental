package project.CarRental.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testSetAndGetStreet() {
        Address address = new Address();
        address.setStreet("123 Main St");
        assertEquals("123 Main St", address.getStreet());
    }

    @Test
    public void testSetAndGetCity() {
        Address address = new Address();
        address.setCity("Seattle");
        assertEquals("Seattle", address.getCity());
    }

    @Test
    public void testSetAndGetState() {
        Address address = new Address();
        address.setState("WA");
        assertEquals("WA", address.getState());
    }

    @Test
    public void testSetAndGetZip() {
        Address address = new Address();
        address.setZip("98101");
        assertEquals("98101", address.getZip());
    }

    @Test
    public void testEqualsAndHashCode() {
        Address address1 = Address.builder()
                .street("123 Main St")
                .city("Seattle")
                .state("WA")
                .zip("98101")
                .build();

        Address address2 = Address.builder()
                .street("123 Main St")
                .city("Seattle")
                .state("WA")
                .zip("98101")
                .build();

        Address address3 = Address.builder()
                .street("456 Elm St")
                .city("Portland")
                .state("OR")
                .zip("97201")
                .build();

        assertTrue(address1.equals(address2) && address2.equals(address1));
        assertTrue(address1.hashCode() == address2.hashCode());
        assertFalse(address1.equals(address3));
        assertFalse(address1.hashCode() == address3.hashCode());
    }
}
