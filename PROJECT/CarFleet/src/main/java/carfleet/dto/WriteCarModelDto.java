package carfleet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class WriteCarModelDto {
    @NotBlank(message = "Type cannot be blank.")
	private String type;
    @NotBlank(message = "Brand cannot be blank.")
	private String brand;
    @NotNull(message = "Price cannot be null.")
	private Double price;
}
