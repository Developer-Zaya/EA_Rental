package carfleet.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class WriteCarDto {
    @NotBlank(message = "License number cannot be blank.")
    private String licensePlate;
    private boolean available = false;
    @NotNull(message = "Model ID cannot be null.")
    private Integer modelId;
}
