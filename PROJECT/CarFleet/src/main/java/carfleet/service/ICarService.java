package carfleet.service;

import java.util.List;

import carfleet.domain.Car;
import carfleet.dto.WriteCarDto;

public interface ICarService {
    List<CarDTO> getAll();

    CarDTO updateCar(int id, WriteCarDto carDto);

    CarDTO getCarById(int id);

    Car getById(int id);

    void reserveCar(int id);

    void delete(int id);

    CarDTO addCar(WriteCarDto createCarDto);
}