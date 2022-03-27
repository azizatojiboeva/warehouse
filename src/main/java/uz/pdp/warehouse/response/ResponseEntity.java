package uz.pdp.warehouse.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseEntity<T> extends org.springframework.http.ResponseEntity<Object> {

    private T data;

    private Integer status;

    public ResponseEntity(T data) {
        this(data, HttpStatus.OK);
    }

    public ResponseEntity(T data, HttpStatus status) {
        super(status);
        this.data = data;
        this.status = status.value();
    }
}
