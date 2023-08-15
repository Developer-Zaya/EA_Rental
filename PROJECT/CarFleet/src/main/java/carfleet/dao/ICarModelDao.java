package carfleet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import carfleet.domain.CarModel;

public interface ICarModelDao extends JpaRepository<CarModel, Integer> {
    List<CarModel> findByType(String type);

    List<CarModel> findByBrand(String brand);

    List<CarModel> findByPrice(Double price);

    List<CarModel> findByTypeAndBrandAndPrice(String type, String brand, Double price);
}
