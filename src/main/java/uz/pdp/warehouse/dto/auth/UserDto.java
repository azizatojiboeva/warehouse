package uz.pdp.warehouse.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.entity.auth.AuthRole;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class UserDto extends GenericDto {
    private String fullName;

    private String password;

    private String email;

    private String phoneNumber;

    private AuthRole authRole;

    private String verificationCode;

    public UserDto(Long id, String fullName, String password, String email, String phoneNumber, AuthRole authRole, String verificationCode) {
        super(id);
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.authRole = authRole;
        this.verificationCode = verificationCode;
    }
}
