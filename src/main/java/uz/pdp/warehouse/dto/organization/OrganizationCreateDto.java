package uz.pdp.warehouse.dto.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

@Setter
public class OrganizationCreateDto implements BaseGenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private String website;

    private String logo;

    private String code;

    private String email;

}
