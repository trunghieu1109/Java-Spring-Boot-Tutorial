package com.example.demo.model;

import com.example.demo.dto.request.AddressDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="User")
@Table(name="tbl_user")
public class User extends AbstractEntity<Long> {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserHasGroup> userHasGroups = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserHasRole> userHasRoles = new HashSet<>();

    public void saveAddress(Address address) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }

        addresses.add(address);
        address.setUser(this);
    }

}
