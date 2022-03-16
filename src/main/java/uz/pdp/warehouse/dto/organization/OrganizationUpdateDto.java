package uz.pdp.warehouse.dto.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

@Setter
@Getter
public class OrganizationUpdateDto extends GenericDto {

    private String name;

    private Double latitude;

    private Double longitude;

    private String website;

    private String logo;

    private String code;

    private String email;

    public OrganizationUpdateDto(String id) {
        super(id);
    }
}
