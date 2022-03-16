package uz.pdp.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.response.AppError;

/**
 * @Author Aziza Tojiboyeva
 */
@ControllerAdvice("uz.pdp.warehouse")
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<AppError> handle500(RuntimeException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new AppError(e.getMessage(),
                        webRequest,
                        HttpStatus.INTERNAL_SERVER_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<AppError> handleValidation(ValidationException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new AppError(e.getMessage(),
                        webRequest, HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }


}
