package carfleet.service;

import java.util.List;

import carfleet.domain.CarModel;
import carfleet.dto.WriteCarModelDto;

public interface ICarModelService {
    public CarModelDTO createCarModel(WriteCarModelDto carModelDto);

    List<CarModelDTO> geAllCarModels();

    CarModelDTO updateCarModel(int id, WriteCarModelDto carModelDto);

    void deleteCarModel(int id);

    CarModelDTO getCarModelById(int id);

    CarModel getById(int id);

    void calculateAvailability(int id);

    List<CarModelDTO> search(String type, String brand, Double price);
}