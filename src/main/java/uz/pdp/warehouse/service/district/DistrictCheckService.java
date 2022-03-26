package uz.pdp.warehouse.service.district;

import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.district.District;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.district.DistrictRepository;

import java.util.Objects;

@Service
public class DistrictCheckService {

    private final DistrictRepository repository;

    public DistrictCheckService(DistrictRepository repository) {
        this.repository = repository;
    }

    public void checkForDistrictExistence(Long id) {
        checkForDistrictExistence(repository.getByIdAndNotDelete(id));
    }

    public void checkForDistrictExistence(District district) {
        if (Objects.isNull(district)) {
            throw new NotFoundException("DISTRICT_NOT_FOUND");
        }
    }
}
