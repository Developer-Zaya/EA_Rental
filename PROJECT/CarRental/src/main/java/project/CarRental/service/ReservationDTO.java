package project.CarRental.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;

    private String startDate;

    private String endDate;

    private Long carId;

    @JsonIgnore
    private CustomerDTO customer;

    @JsonIgnore
    private RentalDTO rental;
}
