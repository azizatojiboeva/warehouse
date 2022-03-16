package uz.pdp.warehouse.repository.auth;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface AuthUserRepository extends AbstractRepository<AuthUser,Long> {

  /*  @Query(value = "select * ")
    AuthUser getAll();*/
}
