package uz.pdp.warehouse.criteria.base;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.criteria.base.BaseCriteria;

@Getter
@Setter
public abstract class AbstractCriteria implements BaseCriteria {

    protected Integer page;

    protected Integer size;

}
