package carfleet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(
            ServiceException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getCode(), e.getMessage()), e.getStatus());
    }
}
