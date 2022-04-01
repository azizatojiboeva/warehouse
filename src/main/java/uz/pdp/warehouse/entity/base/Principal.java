package uz.pdp.warehouse.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@AllArgsConstructor
public class Principal implements BaseEntity {
    private Long id;
    private String email;
    private boolean active;
    private boolean block;


}
