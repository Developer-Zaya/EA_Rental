package carfleet.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarDTO {
    private int id;
    private String licensePlate;
    private boolean available;
    private CarModelDTO carModel;
}
