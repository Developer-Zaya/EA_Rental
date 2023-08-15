package project.CarRental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import project.CarRental.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerNumber(Long customerNumber);

    List<Customer> findByEmail(String email);

    List<Customer> findByName(String name);

    List<Customer> findByEmailAndName(String email, String name);

    @Modifying
    @Transactional
    void deleteByCustomerNumber(Long customerNumber);
}
