package project.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CarRental.domain.Rental;
import project.CarRental.domain.Reservation;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCarId(Long carId);

}
