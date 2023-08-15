package project.CarRental.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PaymentDTO {
    private Long id;

    private String type;

    private double amount;

    @JsonIgnore
    private RentalDTO rental;
}
