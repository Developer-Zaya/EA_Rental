package project.CarRental.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class WriteRentalDto {
    @NotNull(message = "Customer number cannot be null")
    private Long customerNumber;
    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;
    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;
    @NotNull(message = "Car ID cannot be null")
    private Long carId;
    private Long employeeId;
    private Long reservationId;
}
