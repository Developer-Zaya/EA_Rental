package carfleet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carfleet.dto.WriteCarDto;
import carfleet.service.CarDTO;
import carfleet.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDTO getById(
            @PathVariable("id") int carId) {
        return carService.getCarById(carId);
    }

    @PostMapping
    public CarDTO create(@Valid @RequestBody WriteCarDto createCarDto) {
        return carService.addCar(createCarDto);
    }

    @PutMapping("/{id}")
    public CarDTO update(@PathVariable("id") int id, @Valid @RequestBody WriteCarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        carService.delete(id);
    }
}
