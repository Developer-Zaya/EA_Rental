package project.CarRental.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rental")
public class RentalConfiguration {
    private String carFleetUrl;
    private int maxReservationsPerCustomer;

    public String getCarFleetUrl() {
        return carFleetUrl;
    }

    public void setCarFleetUrl(String carFleetUrl) {
        this.carFleetUrl = carFleetUrl;
    }

    public int getMaxReservationsPerCustomer() {
        return maxReservationsPerCustomer;
    }

    public void setMaxReservationsPerCustomer(int maxReservationsPerCustomer) {
        this.maxReservationsPerCustomer = maxReservationsPerCustomer;
    }
}
