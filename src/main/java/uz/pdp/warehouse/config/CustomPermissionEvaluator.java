package uz.pdp.warehouse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.entity.auth.AuthRole;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.entity.base.Principal;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
@RequiredArgsConstructor
public class CustomPermissionEvaluator implements PermissionEvaluator {

    private final AuthUserRepository userRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        Principal principal = (Principal) authentication.getPrincipal();
        if (Objects.isNull(principal) || !"hasAccess".equalsIgnoreCase(String.valueOf(targetDomainObject))) {
            return false;
        }
        Long id = principal.getId();
        return checkPermission(id, permission);
    }

    private boolean checkPermission(Long id, Object permission) {
        AuthUser authUser = userRepository.findById(id).get();
        AuthRole role = authUser.getRole();
        boolean result;
        List<String> permissionsCodeById = userRepository.findPermissionsCodeById(authUser.getId(), role.getId());
        result = permissionsCodeById.stream().
                anyMatch(permissionByCode -> permissionByCode
                        .equalsIgnoreCase(String.valueOf(permission)));
        if (!result) {
            throw new AccessDeniedException("Permission denied due to unauthorized access!");
        }
        return result;
    }


    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId,
                                 String targetType,
                                 Object permission) {
        return false;
    }


}
