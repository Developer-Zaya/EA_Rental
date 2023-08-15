package project.CarRental.service;

import java.util.ArrayList;
import java.util.Collection;

public class CarModelDTO {
	private int id;

	private String type;

	private String brand;

	private double price;

	Collection<CarDTO> cars = new ArrayList<CarDTO>();

	public CarModelDTO() {
	}

	public CarModelDTO(String type, String brand, double price){
		this.type = type;
		this.brand = brand;
		this.price = price;
	}


	public int getId() {
		return id;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "\n\tCarModel{" +
				"\n\tid=" + id +
				"\n\ttype='" + type + '\'' +
				"\n\tbrand='" + brand + '\'' +
				"\n\tprice=" + price +
				"\n\tcars=" + cars +
				"\n\t }";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Collection<CarDTO> getCars() {
		return this.cars;
	}

	public void addCar(CarDTO car) {
		cars.add(car);
	}

	public int getAvailableCars(){
		int available = 0;
		for(CarDTO car : cars) if(car.isAvailable()) available++;
		return available;
	}

}
