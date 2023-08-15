package carfleet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "car_model")
@NoArgsConstructor
public class CarModel {
    @Id
    private int id;
    private String type;
    private String brand;
    private double price;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "model_id")
    List<Car> cars = new ArrayList<>();

    public CarModel(String type, String brand, double price) {
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

}