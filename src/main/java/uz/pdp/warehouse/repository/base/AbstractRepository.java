package uz.pdp.warehouse.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import uz.pdp.warehouse.entity.base.BaseEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<
        E extends BaseEntity,
        K extends Serializable
        > extends JpaRepository<E, K>, BaseGenericRepository {
}