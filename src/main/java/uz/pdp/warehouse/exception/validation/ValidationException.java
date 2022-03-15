package uz.pdp.warehouse.exception.validation;


public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}