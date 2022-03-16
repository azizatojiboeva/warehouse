package uz.pdp.warehouse.dto.base;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public abstract class GenericDto implements BaseGenericDto {
    protected String id;

}
