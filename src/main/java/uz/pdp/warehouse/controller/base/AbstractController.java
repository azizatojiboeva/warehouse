package uz.pdp.warehouse.controller.base;

import lombok.RequiredArgsConstructor;
import uz.pdp.warehouse.service.base.AbstractService;
import uz.pdp.warehouse.service.base.BaseGenericService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseGenericService> {

    protected final S service;
    protected final String API = "/api";
    protected final String VERSION = "/v1";
    protected final String PATH = API + VERSION;

}
