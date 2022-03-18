package uz.pdp.warehouse.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class UserUpdateDto extends GenericDto {
    private String fullName;
    private String email;
    private String phoneNumber;

    @Builder(builderMethodName = "childBuilder")
    public UserUpdateDto(Long id, String fullName, String email, String phoneNumber) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
