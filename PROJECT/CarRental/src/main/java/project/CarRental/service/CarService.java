package project.CarRental.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project.CarRental.config.RentalConfiguration;
import project.CarRental.domain.Rental;
import project.CarRental.domain.Reservation;
import project.CarRental.repository.RentalRepository;
import project.CarRental.repository.ReservationRepository;

@Service
public class CarService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RentalConfiguration configuration;

    public List<CarModelDTO> getAllCars() {
        CarModelDTO[] carModels = restTemplate.getForObject(configuration.getCarFleetUrl() + "/car_models/",
                CarModelDTO[].class);
        List<CarModelDTO> allCarModels = parseCarModels(carModels);
        return allCarModels;
    }

    public List<CarModelDTO> parseCarModels(CarModelDTO[] carModels) {
        List<CarModelDTO> allCarModels = new ArrayList<CarModelDTO>();
        for (CarModelDTO carModel : carModels) {
            for (CarDTO car : carModel.getCars()) {
                List<Rental> allRentals = rentalRepository.findByCarId((long) car.getId());
                List<Reservation> allReservations = reservationRepository.findByCarId((long) car.getId());

                List<RentalDTO> allRentalDTOs = new ArrayList<>();
                List<ReservationDTO> allReservationDTOs = new ArrayList<>();

                for (Rental rental : allRentals) {
                    allRentalDTOs.add(modelMapper.map(rental, RentalDTO.class));
                }
                for (Reservation reservation : allReservations) {
                    allReservationDTOs.add(modelMapper.map(reservation, ReservationDTO.class));
                }

                car.setRentals(allRentalDTOs);
                car.setReservations(allReservationDTOs);
            }
            allCarModels.add(carModel);
        }

        return allCarModels;
    }

}