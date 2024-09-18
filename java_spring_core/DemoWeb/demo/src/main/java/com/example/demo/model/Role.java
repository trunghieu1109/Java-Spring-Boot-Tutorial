package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Role")
@Table(name="tbl_role")
public class Role extends AbstractEntity<Integer> {

    @Column(name="name")
    private String name;

    @Column(name="decription")
    private String description;

    @OneToMany(mappedBy = "role")
    private Set<UserHasRole> userHasRoles = new HashSet<>();

    @OneToMany(mappedBy = "role")
    private Set<RoleHasPermission> userHasPermissions = new HashSet<>();


}
