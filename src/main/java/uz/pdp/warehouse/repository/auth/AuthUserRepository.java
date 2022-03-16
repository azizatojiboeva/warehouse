package uz.pdp.warehouse.repository.auth;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import javax.transaction.Transactional;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface AuthUserRepository extends AbstractRepository<AuthUser, Long> {


    @Modifying
    @Query("update AuthUser a set a.deleted = true where a.id =:id")
    void softDelete(@Param("id") Long id);


    @Modifying
    @Query("update AuthUser a set a.password =:newPassword where a.id =:id")
    void resetPassword( @Param("newPassword")String newPassword,@Param("id") Long id);


    @Query("from AuthUser a where a.email =:email")
    AuthUser findByEmail(@Param("email")String email);



}
