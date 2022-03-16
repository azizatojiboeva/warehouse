package uz.pdp.warehouse.dto.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class LoginDto {
    private String email;
    private String password;
}
