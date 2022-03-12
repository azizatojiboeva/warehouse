package uz.pdp.warehouse.entity.market;

import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.district.District;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Market extends Auditable {

    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

}
