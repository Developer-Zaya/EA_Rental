package project.CarRental.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long customerNumber;

    private String name;

    private String email;

    private List<ReservationDTO> reservations = new ArrayList<>();

    private List<RentalDTO> rentals = new ArrayList<>();
}
