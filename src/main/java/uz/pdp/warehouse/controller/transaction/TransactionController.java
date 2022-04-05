package uz.pdp.warehouse.controller.transaction;

import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse.controller.base.AbstractController;
import uz.pdp.warehouse.criteria.organization.OrganizationCriteria;
import uz.pdp.warehouse.criteria.transaction.TransactionCriteria;
import uz.pdp.warehouse.dto.transaction.TransactionCreateDto;
import uz.pdp.warehouse.dto.transaction.TransactionUpdateDto;
import uz.pdp.warehouse.dto.transaction.transactionElement.TransactionDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.transaction.transaction.TransactionService;

import java.util.List;

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

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<DataDto<Boolean>> update(@RequestBody TransactionUpdateDto transactionUpdateDto) {
        return service.update(transactionUpdateDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DataDto<Void>> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<TransactionDto>> get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "list")
    public ResponseEntity<DataDto<List<TransactionDto>>> getAll( TransactionCriteria criteria) {
        return service.getAll(criteria);
    }

    @GetMapping(value = "list/{market_id}")
    public ResponseEntity<DataDto<List<TransactionDto>>> getAllByMarketId(@PathVariable("market_id") Long id) {
        return service.getAllByMarketId(id);
    }


}
