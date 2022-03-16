package uz.pdp.warehouse.dto.base;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public abstract class GenericDto implements BaseGenericDto {
    public Long id;
}
