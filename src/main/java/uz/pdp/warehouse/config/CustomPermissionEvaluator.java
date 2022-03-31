package uz.pdp.warehouse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import uz.pdp.warehouse.entity.base.Principal;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;

import java.io.Serializable;
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
        if (!Objects.isNull(principal) && "hasAccess".equalsIgnoreCase(String.valueOf(targetDomainObject))) {
            return false;
        }
        String role = principal.getRole();
        Long id = principal.getId();
        return checkPermission(id, role, permission);
    }

    private boolean checkPermission(Long id, String role, Object permission) {
        return true;
    }


    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }


}
