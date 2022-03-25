package uz.pdp.warehouse.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

public class OrganizationUpdateDto extends GenericDto {

    public String name;

    public Double latitude;

    public Double longitude;

    public String website;

    public String logo;

    public String code;

    public String email;

    @Builder(builderMethodName = "childBuilder")
    public OrganizationUpdateDto(Long id,
                                 String name,
                                 Double latitude,
                                 Double longitude,
                                 String website,
                                 String logo,
                                 String code,
                                 String email) {
        super(id);
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.website = website;
        this.logo = logo;
        this.code = code;
        this.email = email;
    }
}
