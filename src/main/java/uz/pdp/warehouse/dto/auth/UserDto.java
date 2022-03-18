package uz.pdp.warehouse.dto.auth;

import uz.pdp.warehouse.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
public class UserDto extends GenericDto {
    public String fullName;

    public String password;

    public String email;

    public String phoneNumber;

    public UserDto(Long id) {
        super(id);
    }
}
