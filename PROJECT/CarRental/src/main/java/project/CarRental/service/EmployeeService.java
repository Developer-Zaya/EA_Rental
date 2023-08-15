package project.CarRental.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.CarRental.domain.Employee;
import project.CarRental.domain.Employee;
import project.CarRental.repository.EmployeeRepository;
import project.CarRental.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Autowired
    ModelMapper modelMapper;

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        List<EmployeeDTO> allEmployeeDTOs = new ArrayList<>();
        for (Employee emp : allEmployees) {
            allEmployeeDTOs.add(modelMapper.map(emp, EmployeeDTO.class));
        }
        return allEmployeeDTOs;
    }

    public EmployeeDTO createEmployee(String kind, String email, String name) {
        Employee employee = Employee.builder().kind(kind).email(email).name(name).build();
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

}