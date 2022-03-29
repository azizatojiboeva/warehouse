package uz.pdp.warehouse.entity.auth;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AuthUser extends Auditable {

    private String fullName;

    private String password;

    private String email;

    @Column(name = "organization_id")
    private Long organizationId;

    private String verificationCode;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AuthRole role;

}
