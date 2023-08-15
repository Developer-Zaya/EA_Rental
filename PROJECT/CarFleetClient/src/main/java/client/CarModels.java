package client;

import java.util.ArrayList;
import java.util.List;

public class CarModels {
    List<CarModelDTO> carModelList = new ArrayList<CarModelDTO>();

    public List<CarModelDTO> getCarModelList() {
        return carModelList;
    }

    public void setCarModelList(List<CarModelDTO> carModelList) {
        this.carModelList = carModelList;
    }

    @Override
    public String toString() {
        return "CarModels{" +
                "carModelList=" + carModelList +
                '}';
    }
}
