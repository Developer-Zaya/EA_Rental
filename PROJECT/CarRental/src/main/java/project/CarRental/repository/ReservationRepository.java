package project.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CarRental.domain.Customer;
import project.CarRental.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCarId(Long carId);
}
