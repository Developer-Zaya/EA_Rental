package project.CarRental.repository;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.CarRental.domain.Customer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByCustomerNumber() {
        Customer customer = new Customer();
        customer.setCustomerNumber(1L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        customerRepository.save(customer);

        Optional<Customer> foundCustomer = customerRepository.findByCustomerNumber(1L);

        assertTrue(foundCustomer.isPresent());
        assertEquals("John", foundCustomer.get().getName());
        assertEquals("john@example.com", foundCustomer.get().getEmail());
    }

    @Test
    void testFindByEmail() {
        Customer customer1 = new Customer();
        customer1.setCustomerNumber(1L);
        customer1.setName("John");
        customer1.setEmail("john@example.com");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(2L);
        customer2.setName("Mary");
        customer2.setEmail("mary@example.com");
        customerRepository.save(customer2);

        List<Customer> foundCustomers = customerRepository.findByEmail("john@example.com");

        assertEquals(1, foundCustomers.size());
        assertEquals("John", foundCustomers.get(0).getName());
    }

    @Test
    void testFindByName() {
        Customer customer1 = new Customer();
        customer1.setCustomerNumber(1L);
        customer1.setName("John");
        customer1.setEmail("john@example.com");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(2L);
        customer2.setName("John");
        customer2.setEmail("mary@example.com");
        customerRepository.save(customer2);

        List<Customer> foundCustomers = customerRepository.findByName("John");

        assertEquals(2, foundCustomers.size());
        assertEquals("john@example.com", foundCustomers.get(0).getEmail());
        assertEquals("mary@example.com", foundCustomers.get(1).getEmail());
    }

    @Test
    void testFindByEmailAndName() {
        Customer customer1 = new Customer();

        customer1.setCustomerNumber(1L);
        customer1.setName("John");
        customer1.setEmail("john@example.com");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber(2L);
        customer2.setName("Mary");
        customer2.setEmail("mary@example.com");
        customerRepository.save(customer2);
        Customer customer3 = new Customer();
        customer3.setCustomerNumber(3L);
        customer3.setName("John");
        customer3.setEmail("mary@example.com");

        customerRepository.save(customer3);

        List<Customer> foundCustomers = customerRepository.findByEmailAndName("mary@example.com", "John");

        assertEquals(1, foundCustomers.size());
        assertEquals(3L, foundCustomers.get(0).getCustomerNumber());
    }

    @Test
    void testDeleteByCustomerNumber() {
        Customer customer = new Customer();
        customer.setCustomerNumber(1L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        customerRepository.save(customer);

        customerRepository.deleteByCustomerNumber(1L);

        Optional<Customer> deletedCustomer = customerRepository.findByCustomerNumber(1L);
        assertFalse(deletedCustomer.isPresent());
    }
}
