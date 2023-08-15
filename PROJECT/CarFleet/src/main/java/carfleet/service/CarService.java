package carfleet.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carfleet.dao.ICarDao;
import carfleet.domain.Car;
import carfleet.domain.CarModel;
import carfleet.dto.WriteCarDto;
import carfleet.exception.Exceptions;

@Service
public class CarService implements ICarService {

	@Autowired
	private ICarDao carDAO;
	@Autowired
	private CarModelService carModelService;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CarDTO> getAll() {
		List<Car> cars = carDAO.findAll();
		return cars.stream().map(x -> modelMapper.map(x, CarDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CarDTO getCarById(int id) {
		Car car = getById(id);

		return modelMapper.map(car, CarDTO.class);
	}

	@Override
	public Car getById(int id) {
		Optional<Car> optionalCar = carDAO.findById(id);

		if (!optionalCar.isPresent()) {
			throw Exceptions.CAR_NOT_FOUND;
		}

		return optionalCar.get();
	}

	@Override
	public CarDTO addCar(WriteCarDto createCarDto) {
		CarModel carModel = carModelService.getById(createCarDto.getModelId());
		Car car = modelMapper.map(createCarDto, Car.class);
		car.setCarModel(carModel);
		carDAO.save(car);
		return modelMapper.map(car, CarDTO.class);
	}

	@Override
	public CarDTO updateCar(int id, WriteCarDto carDto) {
		Car car = getById(id);
		CarModel carModel = carModelService.getById(carDto.getModelId());

		car.setAvailable(carDto.isAvailable());
		car.setLicensePlate(carDto.getLicensePlate());
		car.setCarModel(carModel);

		carDAO.save(car);
		return modelMapper.map(car, CarDTO.class);
	}

	@Override
	public void delete(int id) {
		Car car = getById(id);
		carDAO.delete(car);
	}

	@Override
	public void reserveCar(int id) {
		Car car = carDAO.getById(id);
		car.setAvailable(false);
		carModelService.calculateAvailability(car.getCarModel().getId());
		carDAO.save(car);
	}

}