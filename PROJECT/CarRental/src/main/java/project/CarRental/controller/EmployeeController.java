package project.CarRental.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.CarRental.service.EmployeeDTO;
import project.CarRental.service.EmployeeService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestParam("kind") String kind,
                                            @RequestParam("email") String email,
                                            @RequestParam("name") String name) {
        EmployeeDTO employee = employeeService.createEmployee(kind, email, name);
        return new ResponseEntity<EmployeeDTO>(employee, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
    }
}
