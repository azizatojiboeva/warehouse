package uz.pdp.warehouse.entity.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
public class Organization extends Auditable {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "owner_id", nullable = true)
    private Long ownerId;

    private Double latitude;

    private Double longitude;

    @Column(nullable = false, unique = true)
    private String website;

    private String logo;

    private String code;

    @Column(nullable = false, unique = true)
    private String email;


    public Organization() {
    }
}
