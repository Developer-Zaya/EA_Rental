package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeGateway {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RentalConfiguration configuration;

    public EmployeeDTO createEmployee(String kind, String email, String name) {
        EmployeeDTO employeeDTO = restTemplate.postForObject(configuration.getServerUrl()+"/employees/?kind={kind}&email={email}&name={name}", null, EmployeeDTO.class, kind, email, name);
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() {
        Employees employees = restTemplate.getForObject(configuration.getServerUrl()+"/employees/", Employees.class);
        return employees.getEmployeeList();
    }

}
