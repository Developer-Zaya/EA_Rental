package carfleet.service;

import carfleet.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter {
    public static Car getCarFromCarDTO(CarDTO carDto){
        Car car = new Car();
        car.setLicensePlate(carDto.getLicensePlate());
        car.setAvailable(carDto.isAvailable());
        return car;
    }
    public static CarDTO getCarDTOFromCar(Car car){
        if(car ==null) return null;
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setAvailable(car.isAvailable());
        carDTO.setLicensePlate(car.getLicensePlate());
        return carDTO;
    }

    public static List<CarDTO> getCarsDTOFromCars(List<Car> cars){
        List<CarDTO> carsDTO = new ArrayList<CarDTO>();
        for (Car car : cars){
            carsDTO.add(getCarDTOFromCar(car));
        }
        return carsDTO;
    }
}
