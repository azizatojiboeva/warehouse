package uz.pdp.warehouse.service.base;

import uz.pdp.warehouse.mapper.base.BaseGenericMapper;
import uz.pdp.warehouse.repository.base.BaseGenericRepository;
import uz.pdp.warehouse.validator.base.BaseGenericValidator;

public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper,
        V extends BaseGenericValidator
        > implements BaseGenericService {

    protected final M mapper;
    protected final V validator;
    protected final R repository;

    protected AbstractService(M mapper, V validator, R repository) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
    }
}