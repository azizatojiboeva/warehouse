package uz.pdp.warehouse.service.auth;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.auth.AuthUserRepository;

import java.util.Objects;

@Service
public class AuthUserCheckService {

    private final AuthUserRepository repository;

    public AuthUserCheckService(AuthUserRepository repository) {
        this.repository = repository;
    }

    public void checkProductExistence(Long agentId) {
        checkProductExistence(repository.findByIdAndDeletedFalse(agentId));
    }

    public void checkProductExistence(AuthUser agent) {
        if (Objects.isNull(agent))
            throw new NotFoundException("USER_NOT_FOUND");
    }
}
