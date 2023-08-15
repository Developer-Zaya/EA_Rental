package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CarGateway {

    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private FleetProperties fleetProperties;

    public void createCarModel(String type, String brand, double price) {
        restTemplate.postForObject(fleetProperties.getServerUrl() + "/car_models/?type={type}&brand={brand}&price={price}", null, CarModelDTO.class, type, brand, price);
    }

    public void updateCarModel(int id, String type, String brand, double price) {

        String url = fleetProperties.getServerUrl()+"/car_models/{id}?type={type}&brand={brand}&price={price}";
        Map<String, String> params = new HashMap<>();
        params.put("id", Integer.toString(id));
        params.put("type", type);
        params.put("brand", brand);
        params.put("price", Double.toString(price));

        restTemplate.exchange(url, HttpMethod.PUT, null, Void.class, params);
        getCarModelById(id);
    }

    public CarDTO updateCar(int id, boolean available, String licensePlate) {
        restTemplate.put(fleetProperties.getServerUrl()+"/cars/{id}?available={available}&licensePlate={licensePlate}", null, Integer.toString(id), available, licensePlate);
        return getCarById(id);
    }

    public CarModelDTO getCarModelById(int id) {
        return restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/{id}", CarModelDTO.class, id);
    }

    public CarDTO getCarById(int id) {
        return restTemplate.getForObject(fleetProperties.getServerUrl()+"/cars/{id}", CarDTO.class, id);
    }

    public List<CarDTO> getAllCars(int id) {
        CarDTO[] cars = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/{id}/cars", CarDTO[].class, id);
        assert cars != null;
        return parseCars(cars);
    }

    public List<CarModelDTO> getAllCarModels() {
        CarModelDTO[] carModels = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/", CarModelDTO[].class);
        assert carModels != null;
        return parseCarModels(carModels);
    }

    public List<CarModelDTO> parseCarModels(CarModelDTO[] carModels) {
        return new ArrayList<CarModelDTO>(Arrays.asList(carModels));
    }
    public List<CarDTO> parseCars(CarDTO[] cars) {
        return new ArrayList<CarDTO>(Arrays.asList(cars));
    }

    public List<CarModelDTO> getCarModelsByType(String type) {
        CarModelDTO[] carModels = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/?type={type}", CarModelDTO[].class, type);
        return parseCarModels(carModels);
    }

    public List<CarModelDTO> getCarModelsByBrand(String brand) {
        CarModelDTO[] carModels = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/?brand={brand}", CarModelDTO[].class, brand);
        return parseCarModels(carModels);
    }

    public List<CarModelDTO> getCarModelsByPrice(double price) {
        CarModelDTO[] carModels = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models/?price={price}", CarModelDTO[].class, price);
        return parseCarModels(carModels);
    }

    public List<CarModelDTO> getCarModelsByTypeBrandPrice(String type, String brand, double price) {
        CarModelDTO[] carModels = restTemplate.getForObject(fleetProperties.getServerUrl()+"/car_models?type={type}&brand={brand}&price={price}", CarModelDTO[].class, type, brand, price);
        return parseCarModels(carModels);
    }

    public void deleteCarModel(int id) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Integer.toString(id));
        restTemplate.delete(fleetProperties.getServerUrl()+"/car_models/{id}", params);
    }

    public CarModelDTO addCar(int id, boolean available, String licensePlate) {
        CarModelDTO car = restTemplate.postForObject(fleetProperties.getServerUrl()+"/car_models/{id}/cars?available={available}&licensePlate={licensePlate}", null, CarModelDTO.class, id, available, licensePlate);
        return car;
    }
}
