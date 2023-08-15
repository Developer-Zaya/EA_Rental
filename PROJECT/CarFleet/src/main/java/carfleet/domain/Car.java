package carfleet.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String licensePlate;
	private boolean available;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id")
	private CarModel carModel;

	public Car(String licensePlate, boolean available, CarModel carModel) {
		this.licensePlate = licensePlate;
		this.available = available;
		this.carModel = carModel;
	}
}
