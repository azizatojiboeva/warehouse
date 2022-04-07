package uz.pdp.warehouse.repository.auth;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface AuthUserRepository extends AbstractRepository<AuthUser, Long> {

    @Transactional
    @Modifying
    @Query("update AuthUser a set a.deleted = true where a.id =:id")
    void softDelete(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query("update AuthUser a set a.password =:newPassword where a.id =:id")
    void resetPassword( @Param("newPassword")String newPassword,@Param("id") Long id);

    @Query("from AuthUser where phoneNumber =:number")
    AuthUser findByPhoneNumber(@Param("number") String number);


    @Query("from AuthUser a where a.email =:email")
    AuthUser findByEmail(@Param("email")String email);

    AuthUser findByIdAndDeletedFalse(Long id);

   @Query(value = " select distinct ap.code from public.users u join public.auth_role_permissions arp on arp.auth_role_id = ?2  and u.id = ?1 join public.auth_permission ap on arp.permissions_id = ap.id", nativeQuery = true)
   List<String> findPermissionsCodeById(@Param("id") Long id, @Param("role_id") Long role_id);

}
