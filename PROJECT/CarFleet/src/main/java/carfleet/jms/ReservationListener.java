package carfleet.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import carfleet.service.CarService;

@Component
public class ReservationListener {
    @Autowired
    CarService carService;

    @JmsListener(destination = "reservation")
    public synchronized void reserve(int carId) {
        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("Reservation of car with id " + carId);
        System.out.println("#######################");
        System.out.println("#######################");
        System.out.println("#######################");
        carService.reserveCar(carId);
    }
}
