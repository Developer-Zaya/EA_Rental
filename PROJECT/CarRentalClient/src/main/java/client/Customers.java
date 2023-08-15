package client;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();

    public List<CustomerDTO> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerDTO> customerList) {
        this.customerList = customerList;
    }
}
