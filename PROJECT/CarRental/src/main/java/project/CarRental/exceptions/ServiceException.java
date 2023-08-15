package project.CarRental.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private final HttpStatus status;
    private final String code;

    public ServiceException(HttpStatus status, String code, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

}
