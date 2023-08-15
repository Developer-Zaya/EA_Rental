package carfleet.exception;

import org.springframework.http.HttpStatus;

public class Exceptions {
        public static final ServiceException CAR_MODEL_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "CF001", "The car model is not found.");
        public static final ServiceException CAR_NOT_FOUND = new ServiceException(HttpStatus.NOT_FOUND,
                        "CF002", "The car  is not found.");
}
