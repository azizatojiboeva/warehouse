package uz.pdp.warehouse.entity.auth;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth_role")
public class AuthRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @OneToMany(mappedBy = "authRole",fetch = FetchType.LAZY)
    private Set<AuthPermission> permissions;

    @OneToOne(mappedBy = "role",fetch = FetchType.LAZY)
    private AuthUser authUser;


}
