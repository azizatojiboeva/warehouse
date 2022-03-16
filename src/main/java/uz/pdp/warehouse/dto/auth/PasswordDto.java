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
public class PasswordDto extends GenericDto {
    private String oldPass;
    private String newPassword;

    @Builder(builderMethodName = "childBuilder")
    public PasswordDto(Long id, String oldPass, String newPassword) {
        super(id);
        this.oldPass = oldPass;
        this.newPassword = newPassword;
    }
}
