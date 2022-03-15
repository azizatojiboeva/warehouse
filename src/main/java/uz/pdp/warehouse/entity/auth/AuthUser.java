package uz.pdp.warehouse.entity.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class AuthUser extends Auditable {

    private String fullName;

    private String password;

    private String email;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AuthRole role;

}
