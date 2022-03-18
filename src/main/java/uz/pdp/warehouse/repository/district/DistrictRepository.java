package uz.pdp.warehouse.repository.district;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.warehouse.entity.district.District;
import uz.pdp.warehouse.repository.base.AbstractRepository;

import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 2:19 PM,3/17/2022
 */
@Repository
public interface DistrictRepository extends AbstractRepository<District, Long> {
//  @Query(value = "select * from organization where not is_deleted and id = :id", nativeQuery = true)

    @Query(value = " update all_schema.district d set is_deleted = true , name = name||?2  where  d.id = ?1", nativeQuery = true)
    void deleteSoft(Long id , String key);

    @Query(value = "select * from all_schema.district d where not is_deleted and d.id = ?1  ", nativeQuery = true)
    District getByIdAndNotDelete(Long id);

    @Query(value = "select * from all_schema.district where not is_deleted", nativeQuery = true)
    List<District> findAllAndNotIsDelete();
}
