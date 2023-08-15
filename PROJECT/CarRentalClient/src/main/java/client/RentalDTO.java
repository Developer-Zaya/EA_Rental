package client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalDTO {
    private Long id;

    private Date startDate;

    private Date endDate;

    private Long carId;

    private EmployeeDTO rentalEmployeeDTO;

    private CustomerDTO customerDTO;

    private AddressDTO pickup;

    private AddressDTO drop;
}
