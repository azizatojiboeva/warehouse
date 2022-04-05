package uz.pdp.warehouse.service.rollBack;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse.entity.rollback.Rollback;
import uz.pdp.warehouse.exception.NotFoundException;
import uz.pdp.warehouse.repository.rollBack.RollBackRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RollBackCheckService {

    private final RollBackRepository repository;

    public void checkRollBackExistence(Long id) {
        checkRollBackExistence(repository.getByIdAndDeletedFalse(id));
    }

    public void checkRollBackExistence(Rollback rollback) {
        if (Objects.isNull(rollback)) {
            throw new NotFoundException("ROLLBACK_NOT_FOUND");
        }
    }


}
