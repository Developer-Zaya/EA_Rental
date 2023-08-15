package project.CarRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import project.CarRental.config.RentalConfiguration;
import project.CarRental.domain.*;
import project.CarRental.repository.AddressRepository;
import project.CarRental.repository.CustomerRepository;
import project.CarRental.repository.EmployeeRepository;

@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableConfigurationProperties(RentalConfiguration.class)
public class CarRentalApplication implements CommandLineRunner {

        @Autowired
        CustomerRepository customerRepository;

        @Autowired
        EmployeeRepository employeeRepository;

        public static void main(String[] args) {
                SpringApplication.run(CarRentalApplication.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

                // seedingCustomer();
                seedingEmployee();

        }

        // public void seedingCustomer() {

        // Customer customer = Customer.builder()
        // .name("Avinash Ghimire")
        // .email("avinash.ghimire@miu.edu")
        // .build();

        // customerRepository.save(customer);
        // customer = Customer.builder()
        // .name("Cesar Willy")
        // .email("cesar.willy@miu.edu")
        // .build();
        // customerRepository.save(customer);
        // customer = Customer.builder()
        // .name("Battushig Tsogtbaatar")
        // .email("battushig@miu.edu")
        // .build();
        // customerRepository.save(customer);
        // }

        public void seedingEmployee() {
                Employee employee = Employee.builder().name("Max").email("max@miu.com").build();
                employeeRepository.save(employee);

                employee = Employee.builder()
                                .name("Sarah")
                                .email("sarah@miu.com")
                                .kind("Rental")
                                .build();
                employeeRepository.save(employee);

                employee = Employee.builder()
                                .name("maya")
                                .email("maya@miu.com")
                                .kind("FrequentRental")
                                .build();
                employeeRepository.save(employee);
        }
}
