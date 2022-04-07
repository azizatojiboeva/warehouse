package uz.pdp.warehouse.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;
import uz.pdp.warehouse.utils.annotation.Unique;
import uz.pdp.warehouse.utils.annotation.UniqueType;

import javax.validation.constraints.Email;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@AllArgsConstructor
public class UserCreateDto implements BaseGenericDto {

    private String fullName;


    private String password;


    @Email(message = "Please, provide correct format for the email!", regexp = "[a-zA-Z0-9]{1,}[@]{1}[a-z]{5,}[.]{1}+[a-z]{3}")
    @Unique(type = UniqueType.EMAIL, message = "This email is already taken by the user!")
    private String email;

    @Unique(type = UniqueType.PHONENUMBER, message = "This phone number is already taken by the user!")
    private String phoneNumber;

}
