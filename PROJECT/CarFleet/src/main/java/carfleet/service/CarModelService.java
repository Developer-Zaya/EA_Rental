package carfleet.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import carfleet.dao.ICarModelDao;
import carfleet.domain.Car;
import carfleet.domain.CarModel;
import carfleet.dto.WriteCarModelDto;
import carfleet.exception.Exceptions;

@Service
public class CarModelService implements ICarModelService {

	@Autowired
	private ICarModelDao carModelDAO;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CarModelDTO> geAllCarModels() {
		List<CarModel> carModels = carModelDAO.findAll();
		return carModels.stream().map(x -> modelMapper.map(x, CarModelDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CarModelDTO getCarModelById(int id) {
		CarModel carModel = getById(id);
		return modelMapper.map(carModel, CarModelDTO.class);
	}

	@Override
	public CarModel getById(int id) {
		Optional<CarModel> optionalCarModel = carModelDAO.findById(id);

		if (optionalCarModel.isEmpty()) {
			throw Exceptions.CAR_MODEL_NOT_FOUND;
		}

		return optionalCarModel.get();
	}

	@Override
	public CarModelDTO createCarModel(WriteCarModelDto carModelDto) {
		CarModel carModel = modelMapper.map(carModelDto, CarModel.class);
		CarModel returningCarModel = carModelDAO.save(carModel);

		return modelMapper.map(returningCarModel, CarModelDTO.class);
	}

	@Override
	public CarModelDTO updateCarModel(int id, WriteCarModelDto carModelDto) {
		CarModel carModel = getById(id);

		carModel.setType(carModelDto.getType());
		carModel.setBrand(carModelDto.getBrand());
		carModel.setPrice(carModelDto.getPrice());

		CarModel returningCarModel = carModelDAO.save(carModel);

		return modelMapper.map(returningCarModel, CarModelDTO.class);
	}

	@Override
	public void deleteCarModel(int id) {
		CarModel carModel = getById(id);
		carModelDAO.delete(carModel);
	}

	@Override
	public List<CarModelDTO> search(String type, String brand, Double price) {
		List<CarModel> carModels;

		if (!type.isEmpty() && !brand.isEmpty() && price != 0.0) {
			carModels = carModelDAO.findByTypeAndBrandAndPrice(type, brand, price);
		} else if (!type.isEmpty()) {
			carModels = carModelDAO.findByType(type);
		} else if (!brand.isEmpty()) {
			carModels = carModelDAO.findByBrand(brand);
		} else if (price != 0.0) {
			carModels = carModelDAO.findByPrice(price);
		} else {
			carModels = carModelDAO.findAll();
		}

		return carModels.stream().map(x -> modelMapper.map(x, CarModelDTO.class)).collect(Collectors.toList());
	}

	@Override
	public void calculateAvailability(int id) {
		CarModel carModel = getById(id);
		int available = 0;

		for (Car car : carModel.getCars()) {
			if (car.isAvailable())
				available++;
		}

		if (available < 3) {
			jmsTemplate.convertAndSend("availability", "Car with brand " + carModel.getBrand() + " and type "
					+ carModel.getType() + " has low availability.");
		}
	}
}