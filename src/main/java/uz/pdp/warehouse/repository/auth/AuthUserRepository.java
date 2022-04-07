package uz.pdp.warehouse.repository.auth;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface AuthUserRepository extends AbstractRepository<AuthUser, Long> {

    @Transactional
    @Modifying
    @Query(value = "update users us  set is_deleted = true where us.id =:id", nativeQuery = true)
    void softDelete(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = "update users us  set password =:newPassword where us.id =:id", nativeQuery = true)
    void resetPassword(@Param("newPassword") String newPassword, @Param("id") Long id);

    @Query(value = "select * from users us where us.phone_number =:number", nativeQuery = true)
    AuthUser findByPhoneNumber(@Param("number") String number);


    @Query(value = " select  * from users us   where us.email =:email", nativeQuery = true)
    AuthUser findByEmail(@Param("email") String email);

    AuthUser findByIdAndDeletedFalse(Long id);

    @Query(value = " select distinct ap.code from public.users u join public.auth_role_permissions arp on arp.auth_role_id = ?2  and u.id = ?1 join public.auth_permission ap on arp.permissions_id = ap.id", nativeQuery = true)
    List<String> findPermissionsCodeById(@Param("id") Long id, @Param("role_id") Long role_id);


    Optional<AuthUser> findByVerificationCodeAndDeletedFalse(String code);

}
