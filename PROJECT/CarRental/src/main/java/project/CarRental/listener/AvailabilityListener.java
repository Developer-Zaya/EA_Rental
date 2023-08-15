package project.CarRental.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import project.CarRental.service.ReservationService;

@Component
public class AvailabilityListener {
    @Autowired
    ReservationService reservationService;
    @JmsListener(destination = "availability")
    public synchronized void trackAvailability(String message) {
        reservationService.informLowAvailability(message);
    }
}
