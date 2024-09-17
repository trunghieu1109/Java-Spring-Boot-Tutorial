package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updatedAt;


}
