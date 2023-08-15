package project.CarRental.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testSetAndGetId() {
        Employee employee = new Employee();
        employee.setId(1L);
        assertEquals(1L, employee.getId());
    }

    @Test
    public void testSetAndGetName() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testSetAndGetEmail() {
        Employee employee = new Employee();
        employee.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", employee.getEmail());
    }

    @Test
    public void testSetAndGetKind() {
        Employee employee = new Employee();
        employee.setKind("Manager");
        assertEquals("Manager", employee.getKind());
    }
}
