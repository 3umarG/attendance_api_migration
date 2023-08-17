package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "migrations")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name", length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rid", nullable = false)
    private Role rid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squad_number")
    private Squad squadNumber;

    @OneToMany(mappedBy = "scramMaster")
    private Set<Squad> squads = new LinkedHashSet<>();

    @OneToMany(mappedBy = "techLead")
    private Set<Track> tracks = new LinkedHashSet<>();

}