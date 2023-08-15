package client;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();

    public List<EmployeeDTO> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeDTO> employeeList) {
        this.employeeList = employeeList;
    }
}
