package uz.pdp.warehouse.entity.district;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.auth.AuthUser;
import uz.pdp.warehouse.entity.base.Auditable;
import uz.pdp.warehouse.entity.market.Market;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class District extends Auditable {

    private String name;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    private List<Market> markets;

    private Long agentId;
}
