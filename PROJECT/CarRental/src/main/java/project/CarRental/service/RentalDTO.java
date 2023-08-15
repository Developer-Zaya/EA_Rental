package project.CarRental.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {
    private Long id;

    private String startDate;

    private String endDate;

    private Long carId;

    private EmployeeDTO rentalEmployee;

    @JsonIgnore
    private CustomerDTO customer;

    private AddressDTO pickup;

    private AddressDTO drop;

    private ReservationDTO reservation;

    private PaymentDTO payment;
}
