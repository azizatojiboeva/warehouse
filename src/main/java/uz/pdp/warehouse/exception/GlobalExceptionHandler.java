package uz.pdp.warehouse.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.response.AppError;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;


@RestController
@ControllerAdvice("uz.pdp")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<DataDto<AppError>> handleInternal(RuntimeException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto<>(AppErrorDto.builder()
                        .message(e.getMessage())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .path(webRequest.getContextPath())
                        .build()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<DataDto<AppError>> handleAccessDenied(AccessDeniedException e, WebRequest webRequest) {
        return new ResponseEntity <>(
                new DataDto<>(AppErrorDto.builder()
                        .message("Access denied due to non-authorized request!")
                        .status(HttpStatus.FORBIDDEN)
                        .path(webRequest.getContextPath())
                        .build()));

    }


    @Override
    protected org.springframework.http.ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError errorObject : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) errorObject).getField();
            String message = errorObject.getDefaultMessage();
            errors.put(fieldName, message);
        }
        return new org.springframework.http.ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleValidation(ValidationException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto(
                        AppErrorDto.builder()
                                .message(e.getMessage())
                                .status(HttpStatus.NOT_FOUND)
                                .path(webRequest.getContextPath())
                                .build()));
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleBadCredentials(BadCredentialsException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto(
                        AppErrorDto.builder()
                                .message(e.getMessage())
                                .status(HttpStatus.NOT_FOUND)
                                .path(webRequest.getContextPath())
                                .build()));
    }



    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleIllegalArgument(IllegalArgumentException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto(
                        AppErrorDto.builder()
                                .message(e.getMessage())
                                .status(HttpStatus.NOT_FOUND)
                                .path(webRequest.getContextPath())
                                .build()));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleNotFound(NotFoundException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto(
                        AppErrorDto.builder()
                                .message(e.getMessage())
                                .status(HttpStatus.NOT_FOUND)
                                .path(webRequest.getContextPath())
                                .build()));
    }


}
