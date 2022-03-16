package uz.pdp.warehouse.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.warehouse.dto.base.GenericDto;

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
@Builder(builderMethodName = "childBuilder")
    public OrganizationDto(Long id,
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
