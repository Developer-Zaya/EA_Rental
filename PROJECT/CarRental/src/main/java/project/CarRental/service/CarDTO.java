package project.CarRental.service;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class CarDTO {
    @Setter(value = AccessLevel.NONE)
    private long id;
    private String licensePlate;
    private boolean available;
    private List<ReservationDTO> reservations;
    private List<RentalDTO> rentals;
    private CarModelDTO carModel;
}
