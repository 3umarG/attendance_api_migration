package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "squad", schema = "migrations")
public class Squad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_number", nullable = false)
    private Integer id;

    @Column(name = "squad_name", length = Integer.MAX_VALUE)
    private String squadName;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scram_master_id")
    private User scramMaster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tribe_id")
    private Tribe tribe;

    @OneToMany(mappedBy = "squadNumber")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "squadNumber")
    private Set<User> users = new LinkedHashSet<>();

}