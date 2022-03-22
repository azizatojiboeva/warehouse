package uz.pdp.warehouse.service.auth;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.exception.auth.AuthUserCheckException;

@Service
public class AuthUserCheckService {
    public void checkProductExistence(Long agentId) {
        throw new AuthUserCheckException();
    }
}
