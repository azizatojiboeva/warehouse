package uz.pdp.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import uz.pdp.warehouse.exception.validation.ValidationException;
import uz.pdp.warehouse.response.AppError;
import uz.pdp.warehouse.response.AppErrorDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;

/**
 * @Author Aziza Tojiboyeva
 */
@ControllerAdvice("uz.pdp.warehouse")
public class GlobalExceptionHandler {

//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<DataDto<AppError>> handle500(RuntimeException e, WebRequest webRequest) {
//        return new ResponseEntity<>(
//                new DataDto<>(AppErrorDto.builder()
//                        .message(e.getMessage())
//                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .path(webRequest.getContextPath())
//                        .build()));
//    }

    @ExceptionHandler({ValidationException.class, IllegalArgumentException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleValidation(ValidationException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto<>(AppErrorDto.builder()
                        .message(e.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .path(webRequest.getContextPath())
                        .build()));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleNotFound(NotFoundException e, WebRequest webRequest) {
        return new ResponseEntity<>(
                new DataDto<>(AppErrorDto.builder()
                        .message(e.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .path(webRequest.getContextPath())
                        .build()));
    }


}
