package project.CarRental.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import project.CarRental.service.CarService;

@Component
public class CarInfoTask {
    @Autowired
    CarService carService;

    @Scheduled(fixedRate = 200000)
    public void printOverview() {
        var result = carService.getAllCars();
        if (result.size() > 1)
            System.out.println(carService.getAllCars());
        else
            System.out.println("Nothing to display");
    }
}
