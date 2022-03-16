package uz.pdp.warehouse.service.auth;

import uz.pdp.warehouse.dto.auth.UserCreateDto;
import uz.pdp.warehouse.dto.auth.UserDto;
import uz.pdp.warehouse.dto.auth.UserUpdateDto;
import uz.pdp.warehouse.service.base.GenericCrudService;

/**
 * @Author Aziza Tojiboyeva
 */
public interface AuthUserService extends GenericCrudService<UserDto, UserCreateDto, UserUpdateDto, Long> {
}
