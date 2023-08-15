package client;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;

    private String name;

    private String email;

    private String kind;
}
