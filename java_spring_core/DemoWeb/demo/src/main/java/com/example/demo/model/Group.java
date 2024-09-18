package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Group")
@Table(name="tbl_group")
public class Group extends AbstractEntity<Long> {

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToMany(mappedBy = "group")
    private Set<UserHasGroup> userHasGroups = new HashSet<>();

}
