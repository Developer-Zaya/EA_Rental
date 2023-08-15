package carfleet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carfleet.dto.WriteCarModelDto;
import carfleet.service.CarModelDTO;
import carfleet.service.ICarModelService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/car_models")
public class CarModelController {
    @Autowired
    private ICarModelService carModelService;

    @GetMapping("/{id}")
    public CarModelDTO getById(@PathVariable int id) {
        return carModelService.getCarModelById(id);
    }

    @PostMapping
    public CarModelDTO create(@Valid @RequestBody WriteCarModelDto carModelDto) {
        return carModelService.createCarModel(carModelDto);
    }

    @PutMapping("/{id}")
    public CarModelDTO update(@PathVariable int id, @Valid @RequestBody WriteCarModelDto carModelDTO) {
        return carModelService.updateCarModel(id, carModelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCarModel(@PathVariable int id) {
        carModelService.deleteCarModel(id);
    }

    @GetMapping
    public List<CarModelDTO> search(@RequestParam(value = "type", required = false, defaultValue = "") String type,
                                            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
                                            @RequestParam(value = "price", required = false) Double price) {
        return carModelService.search(type, brand, price);
    }
}
