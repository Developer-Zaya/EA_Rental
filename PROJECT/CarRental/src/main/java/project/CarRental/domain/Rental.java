package project.CarRental.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long carId;

    @ManyToOne
    @JoinColumn(name="rental_employee_id")
    private Employee rentalEmployee;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="pickup_id")
    private Address pickup;

    @ManyToOne
    @JoinColumn(name="drop_id")
    private Address drop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="payment_id")
    private Payment payment;

    public Rental(LocalDate startDate, LocalDate endDate, Customer customer, Long carId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.carId = carId;
    }

    
}
