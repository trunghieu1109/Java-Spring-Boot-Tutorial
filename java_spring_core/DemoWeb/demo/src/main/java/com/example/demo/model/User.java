package com.example.demo.model;

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
@Entity(name = "tbl_user")
public class User extends AbstractEntity {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String passWord;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();

    public void saveAddress(Address address) {
        if (addresses == null) {
            addresses = new HashSet<>();
        }

        addresses.add(address);
        address.setUser(this);
    }

}
