package carfleet.service;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarModelDTO {
	private int id;
	private String type;
	private String brand;
	private double price;
	@Getter(value = AccessLevel.NONE)
	private int availableCount;
	@JsonIgnore
	Collection<CarDTO> cars = new ArrayList<>();

	public CarModelDTO(String type, String brand, double price) {
		this.type = type;
		this.brand = brand;
		this.price = price;
	}

	public int getAvailableCount() {
		return cars.size();
	}

	public Collection<CarDTO> getCars() {
		return this.cars;
	}

	public void addCar(CarDTO car) {
		cars.add(car);
	}

}
