package uz.pdp.warehouse.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@AllArgsConstructor
public class   UserCreateDto implements BaseGenericDto {
    private String fullName;

    private String password;

    private String email;

    private String phoneNumber;

}
