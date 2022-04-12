package uz.pdp.warehouse.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;
import uz.pdp.warehouse.utils.annotation.Unique;
import uz.pdp.warehouse.utils.annotation.UniqueType;

import javax.validation.constraints.Email;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class UserUpdateDto extends GenericDto {
    private String fullName;

    @Email
    @Unique(type = UniqueType.EMAIL, message = "This email is already taken")
    private String email;


    @Unique(type = UniqueType.PHONENUMBER, message = "Phone number is repeated!")
    private String phoneNumber;



    @Builder(builderMethodName = "childBuilder")
    public UserUpdateDto(Long id, String fullName, String email, String phoneNumber) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
