package project.CarRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.CarRental.service.CarModelDTO;
import project.CarRental.service.CarService;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public List<CarModelDTO> getCars() {
        return carService.getAllCars();
    }
}
