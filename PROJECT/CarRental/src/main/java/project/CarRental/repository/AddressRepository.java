package project.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CarRental.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
