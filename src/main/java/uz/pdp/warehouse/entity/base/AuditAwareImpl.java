package uz.pdp.warehouse.entity.base;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class AuditAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal.getId());
    }

    public CustomUserDetails getCredentials() {
        return  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
