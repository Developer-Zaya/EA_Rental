package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableConfigurationProperties(FleetProperties.class)
public class Application implements CommandLineRunner {

	@Autowired
	private CarGateway carGateway;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//create carModels
		carGateway.createCarModel("Sedan", "Ford", 10000);
		carGateway.createCarModel("Sedan", "Chevrolet", 20000);
		carGateway.createCarModel("SUV", "Jaguar", 30000);
		carGateway.createCarModel("SUV", "BMW", 40000);
		carGateway.createCarModel("Electric", "Lucid", 50000);
		List<CarModelDTO> carModelList = carGateway.getAllCarModels();

		//update car model
		displayAllCarModels(carModelList);
		carGateway.updateCarModel(carModelList.stream().findFirst().get().getId(), "Coupe", "Ford", 10000);
		displayAllCarModels(carGateway.getAllCarModels());


		// find car model by id, type, brand, price and all.
		System.out.println(carGateway.getCarModelById(carModelList.stream().findFirst().get().getId()));
		System.out.println("==========================");
		System.out.println("Car models by type suv");
		displayAllCarModels(carGateway.getCarModelsByType("SUV"));
		System.out.println("==========================");
		System.out.println("Car models by brand BMW");
		displayAllCarModels(carGateway.getCarModelsByBrand("BMW"));
		System.out.println("==========================");
		System.out.println("Car models by price 10000");
		displayAllCarModels(carGateway.getCarModelsByPrice(10000));
		System.out.println("==========================");
		System.out.println("Car models by type electric brand lucid and price 50000");
		displayAllCarModels(carGateway.getCarModelsByTypeBrandPrice("Electric", "Lucid", 50000));
		System.out.println("==========================");


		//delete a car
		System.out.println("Before Deleting: ");
		System.out.println("CarModel Count: " + carModelList.size());
		carGateway.deleteCarModel(carModelList.stream().findFirst().get().getId());
		System.out.println("After Deleting: ");
		System.out.println("CarModel Count: " + (carGateway.getAllCarModels().size()-1));
		displayAllCarModels(carGateway.getAllCarModels());


		//adding a car to carmodel
		carModelList = carGateway.getAllCarModels();
		System.out.println("================");
		System.out.println("Adding car");
		for(CarModelDTO carModelDTO : carModelList) {
			carGateway.addCar(carModelDTO.getId(), true, "A" + (new Random()).nextInt(10000) + 1);
			carGateway.addCar(carModelDTO.getId(), true, "B" + (new Random()).nextInt(10000) + 1);
			carGateway.addCar(carModelDTO.getId(), false, "C" + (new Random()).nextInt(10000) + 1);
			carGateway.addCar(carModelDTO.getId(), true, "D" + (new Random()).nextInt(10000) + 1);

			System.out.println("================");

			//get all cars
			System.out.println("All cars");
			System.out.println(carGateway.getAllCars(carModelList.stream().findFirst().get().getId()));
			System.out.println("================");
		}
	}

	public void displayAllCarModels(List<CarModelDTO> carModelList) {
		for(CarModelDTO carModel : carModelList) {
			System.out.println("Id: " + carModel.getId());
			System.out.println("Brand: " + carModel.getBrand());
			System.out.println("Price: " + carModel.getPrice());
			System.out.println("Type: " + carModel.getType());
			System.out.println("Available: " + carModel.getAvailableCars());
		}
	}
}
