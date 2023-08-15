package project.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CarRental.domain.Payment;
import project.CarRental.domain.Reservation;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
