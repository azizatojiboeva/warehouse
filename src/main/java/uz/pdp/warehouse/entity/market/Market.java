package uz.pdp.warehouse.entity.market;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.district.District;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Market extends Auditable {

    private String name;

    private Double latitude;

    private Double longitude;

    private Double credit;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

}
