package uz.pdp.warehouse.controller.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.transaction.transaction.TransactionService;

@RestController
@RequestMapping(value = "/transaction/")
public class TransactionController extends AbstractController<TransactionService> {

    public TransactionController(TransactionService service) {
        super(service);
    }


    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody TransactionCreateDto transactionCreateDto) {
        return service.create(transactionCreateDto);
    }

}
