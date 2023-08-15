package project.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.CarRental.domain.Employee;
import project.CarRental.domain.Rental;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
