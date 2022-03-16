package uz.pdp.warehouse.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

import javax.persistence.Column;

@Getter
@Setter
public class OrganizationDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private String website;

    private String logo;

    private String code;

    private String email;

    public OrganizationDto(String id) {
        super(id);
    }
}
