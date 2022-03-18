package uz.pdp.warehouse.controller.auth;

import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserService;
import uz.pdp.warehouse.service.base.BaseGenericService;

/**
 * @author Axmadjonov Eliboy, Wed 11:44 AM,3/16/2022
 */

public class AuthController extends AbstractController<AuthUserService> {

    public AuthController(BaseGenericService service) {
        super((AuthUserService) service);
    }



    public ResponseEntity<DataDto<String>> register() {
        return null;
    }
}
