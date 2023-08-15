package client;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long carId;

    private CustomerDTO customerDTO;
}
