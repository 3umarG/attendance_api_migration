package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "track", schema = "migrations")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_code", nullable = false)
    private Integer id;

    @Column(name = "track_name", nullable = false, length = Integer.MAX_VALUE)
    private String trackName;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tech_lead_id")
    private User techLead;

    @OneToMany(mappedBy = "trackCode")
    private Set<Employee> employees = new LinkedHashSet<>();

}