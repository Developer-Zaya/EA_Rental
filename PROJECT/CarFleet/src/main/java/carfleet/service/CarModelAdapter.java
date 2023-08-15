package carfleet.service;

import carfleet.domain.CarModel;
import carfleet.domain.Car;

import java.util.*;

public class CarModelAdapter {
    public static CarModel getCarModelFromCarModelDTO(CarModelDTO carModelDto) {
        CarModel carModel = new CarModel();
        carModel.setBrand(carModelDto.getBrand());
        carModel.setType(carModelDto.getType());
        carModel.setPrice(carModelDto.getPrice());
        for (CarDTO carDto : carModelDto.getCars()) {
            carModel.getCars().add(CarAdapter.getCarFromCarDTO(carDto));
        }
        return carModel;
    }

    public static CarModelDTO getCarModelDTOFromCarModel(CarModel carModel) {
        CarModelDTO carModelDto = new CarModelDTO();
        carModelDto.setId(carModel.getId());
        carModelDto.setBrand(carModel.getBrand());
        carModelDto.setType(carModel.getType());
        carModelDto.setPrice(carModel.getPrice());
        if (carModel.getCars().size() > 0) {

            for (Car car : carModel.getCars()) {
                if(car != null) {
                    CarDTO carDTO = CarAdapter.getCarDTOFromCar(car);
                    if(car!=null || carDTO != null) carModelDto.addCar(carDTO);
                }

            }
        }

        return carModelDto;
    }

    public static List<CarModelDTO> getCarModelDTOListFromCarModelList(List<CarModel> carModels) {
        List<CarModelDTO> carModelDTOs = new ArrayList<CarModelDTO>();
        for (CarModel carModel : carModels) {
            carModelDTOs.add(getCarModelDTOFromCarModel(carModel));
        }
        return carModelDTOs;
    }
}
