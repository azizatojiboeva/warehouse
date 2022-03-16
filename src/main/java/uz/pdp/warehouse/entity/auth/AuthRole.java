package uz.pdp.warehouse.entity.auth;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "auth_role")
public class AuthRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @OneToMany(mappedBy = "authRole")
    private Set<AuthPermission> permissions;

    @OneToOne(mappedBy = "role")
    private AuthUser authUser;



}
