package project.CarRental.exceptions;

import org.springframework.http.HttpStatus;

public class Exceptions {
        public static final ServiceException CUSTOMER_MODEL_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "CR001", "The customer is not found.");
}
