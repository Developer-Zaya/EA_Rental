package carfleet.dao;

import carfleet.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarDao extends JpaRepository<Car, Integer> {
    @Modifying
    @Query("update Car c set c.available = :available, c.licensePlate = :licensePlate where c.id = :id")
    void updateCarByIdAndAvailableAndLicensePlate(int id, String licensePlate, boolean available);
}
