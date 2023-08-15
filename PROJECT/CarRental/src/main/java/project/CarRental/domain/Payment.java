package project.CarRental.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rental_id")
    private Rental rental;
}
