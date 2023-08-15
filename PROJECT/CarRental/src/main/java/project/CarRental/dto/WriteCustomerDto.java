package project.CarRental.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WriteCustomerDto {
    @NotBlank(message = "Email cannot be blank.")
    private String email;
    @NotBlank(message = "Name cannot be blank.")
    private String name;
}
