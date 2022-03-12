package uz.pdp.warehouse.entity.district;

import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.market.Market;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class District extends Auditable {

    private String name;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<Market>markets;


}
