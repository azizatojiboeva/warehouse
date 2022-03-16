package uz.pdp.warehouse.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.dto.auth.UserCreateDto;
import uz.pdp.warehouse.dto.auth.UserDto;
import uz.pdp.warehouse.dto.auth.UserUpdateDto;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.mapper.base.AbstractMapper;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Mapper(componentModel = "spring")
@Component
public interface AuthUserMapper extends AbstractMapper<AuthUser, UserDto, UserCreateDto, UserUpdateDto> {

    @Override
    UserDto toDto(AuthUser entity);

    @Override
    List<UserDto> toDto(List<AuthUser> entities);

    @Override
    AuthUser fromCreateDto(UserCreateDto createDto);

    @Override
    AuthUser fromUpdateDto(UserUpdateDto updateDto);
}
