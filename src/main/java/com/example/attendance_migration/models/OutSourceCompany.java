package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "out_source_companies", schema = "migrations")
public class OutSourceCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_number", nullable = false)
    private Integer id;

    @Column(name = "comp_name", nullable = false, length = Integer.MAX_VALUE)
    private String compName;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @OneToMany(mappedBy = "comanyNumber")
    private Set<Employee> employees = new LinkedHashSet<>();

}