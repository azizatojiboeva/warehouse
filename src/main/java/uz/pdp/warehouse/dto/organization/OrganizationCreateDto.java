package uz.pdp.warehouse.dto.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.BaseGenericDto;

public class OrganizationCreateDto implements BaseGenericDto {

    public String name;

    public Double latitude;

    public Double longitude;

    public String website;

    public String logo;

    public String code;

    public String email;

}
