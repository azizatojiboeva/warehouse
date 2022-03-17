package uz.pdp.warehouse.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.auth.AuthRole;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {


    @Query("select a from AuthRole a where a.code = ?1")
    AuthRole findByCode(String code);
}
