package uz.pdp.warehouse.entity.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uz.pdp.warehouse.entity.base.Auditable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

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


    @Builder(builderMethodName = "childBuilder")
    public AuthUser(Long id, Long createdBy, Long updatedBy,
                    LocalDateTime createdAt, LocalDateTime updatedAt,
                    boolean deleted, String fullName, String password, String email,
                    String phoneNumber, AuthRole role) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted);
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
