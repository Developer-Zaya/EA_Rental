package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(RentalConfiguration.class)
public class Application implements CommandLineRunner {

	@Autowired
	CustomerGateway customerGateway;

	@Autowired
	ReservationGateway reservationGateway;

	@Autowired
	RentalGateway rentalGateway;

	@Autowired
	EmployeeGateway employeeGateway;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerGateway.createCustomer("roman.khadka@miu.edu", "Roman Khadka");
		customerGateway.createCustomer("jane.doe@miu.edu", "Jane Doe");
		customerGateway.createCustomer("john.doe@miu.edu", "John Doe");
		customerGateway.createCustomer("andy.rubin@miu.edu", "Andy Rubin");
		List<CustomerDTO> customers = customerGateway.getAllCustomers();

		displayAllCustomers(customers);
		customerGateway.updateCustomer(customers.stream().findFirst().get().getCustomerNumber(), "roman.khadka@miu.edu", "Roman K.");
		displayAllCustomers(customerGateway.getAllCustomers());

		customerGateway.deleteCustomer(customers.stream().findFirst().get().getCustomerNumber());
		displayAllCustomers(customerGateway.getAllCustomers());

		List<CustomerDTO> allCustomers = customerGateway.findCustomer("andy.rubin@miu.edu", null);
		displayAllCustomers(allCustomers);

		allCustomers = customerGateway.findCustomer(null, "John Doe");
		displayAllCustomers(allCustomers);

		ReservationDTO reservationDTO = reservationGateway.createReservation(customers.stream().findFirst().get().getCustomerNumber(), LocalDate.now(), LocalDate.now(), 1L);
		System.out.println(reservationDTO);

		reservationDTO = reservationGateway.createReservation(customers.stream().findAny().get().getCustomerNumber(), LocalDate.now(), LocalDate.now(), 2L);
		System.out.println(reservationDTO);

		reservationDTO = reservationGateway.createReservation(customers.stream().findAny().get().getCustomerNumber(), LocalDate.now(), LocalDate.now(), 2L);
		System.out.println(reservationDTO);

		reservationDTO = reservationGateway.createReservation(customers.stream().findAny().get().getCustomerNumber(), LocalDate.now(), LocalDate.now(), 2L);
		System.out.println(reservationDTO);

		RentalDTO rentalDTO = rentalGateway.createRental(reservationDTO.getCustomerDTO().getCustomerNumber(), LocalDate.now(), LocalDate.now(), 1L, 2L, reservationDTO.getId());
		System.out.println(rentalDTO);

		rentalDTO = rentalGateway.pickup(rentalDTO.getId(), "1000N 4th", "Fairfield", "IA", "52557");
		System.out.println(rentalDTO);

		rentalDTO = rentalGateway.drop(rentalDTO.getId(), "10301 Ranch Rd.", "Austin", "TX", "78745");
		System.out.println(rentalDTO);

		PaymentDTO paymentDTO = rentalGateway.pay(rentalDTO.getId(), "credit card", 10000);
		System.out.println(paymentDTO);

		employeeGateway.createEmployee("Rental", "ray@office.com", "Ray Thomas");
		employeeGateway.createEmployee("Rental", "julie@office.com", "Julie Anderson");

		displayAllEmployees(employeeGateway.getAllEmployees());
	}

	public void displayAllCustomers(List<CustomerDTO> customersList) {
		for(CustomerDTO customer : customersList) {
			System.out.println("Customer Number: " + customer.getCustomerNumber());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
		}
	}
	public void displayAllEmployees(List<EmployeeDTO> employeesList) {
		for(EmployeeDTO emp : employeesList) {
			System.out.println("Employee Kind: " + emp.getKind());
			System.out.println("Name: " + emp.getName());
			System.out.println("Email: " + emp.getEmail());
		}
	}
}
