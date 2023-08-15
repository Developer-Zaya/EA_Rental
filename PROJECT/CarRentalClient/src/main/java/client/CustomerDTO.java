package client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long customerNumber;

    private String name;

    private String email;

    private List<ReservationDTO> reservationDTOS = new ArrayList<>();

    private List<RentalDTO> rentalDTOS = new ArrayList<>();

}
