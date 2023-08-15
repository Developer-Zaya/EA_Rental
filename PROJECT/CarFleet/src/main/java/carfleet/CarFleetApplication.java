package carfleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableJpaRepositories("carfleet.dao")
public class CarFleetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarFleetApplication.class, args);
    }

}
