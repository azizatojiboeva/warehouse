package uz.pdp.warehouse.controller.transaction;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementCreateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionElementUpdateDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.transaction.transactionElement.TransactionElementService;

import java.util.List;

@RestController
@RequestMapping(value = "/transaction_element/")
public class TransactionElementController extends AbstractController<TransactionElementService> {

    public TransactionElementController(TransactionElementService service) {
        super(service);
    }

    @PostMapping(value = "create")
    public ResponseEntity<DataDto<Long>> create(@RequestBody TransactionElementCreateDto transactionElementCreateDto) {
        return service.create(transactionElementCreateDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody TransactionElementUpdateDto transactionElementUpdateDto) {
        return service.update(transactionElementUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<TransactionElementDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<TransactionElementDto>>> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "list/{transactionId}")
    public ResponseEntity<DataDto<List<TransactionElementDto>>> getAll(@PathVariable("transactionId") Long transactionId) {
        return service.getAllByTransactionId(transactionId);
    }

}
