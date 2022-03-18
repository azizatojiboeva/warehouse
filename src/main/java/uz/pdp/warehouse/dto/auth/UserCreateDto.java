package uz.pdp.warehouse.dto.auth;

import uz.pdp.warehouse.dto.base.BaseGenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
public class UserCreateDto implements BaseGenericDto {
    public String fullName;

    public String password;

    public String email;

    public String phoneNumber;
}
