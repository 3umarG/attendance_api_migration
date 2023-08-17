package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles", schema = "migrations")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role_name", nullable = false, length = Integer.MAX_VALUE)
    private String roleName;

    @OneToMany(mappedBy = "rid")
    private Set<User> users = new LinkedHashSet<>();

}