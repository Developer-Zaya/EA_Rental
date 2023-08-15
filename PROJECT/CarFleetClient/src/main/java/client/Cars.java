package client;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<CarDTO> carList = new ArrayList<CarDTO>();

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDTO> carList) {
        this.carList = carList;
    }
}
