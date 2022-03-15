package uz.pdp.warehouse.dto.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
//@Builder
public abstract class GenericDto implements BaseGenericDto {
    public String id;
}
