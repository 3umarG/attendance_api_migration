package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees", schema = "migrations")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "salary")
    private Double salary;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comany_number")
    private OutSourceCompany comanyNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squad_number")
    private Squad squadNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_code")
    private Track trackCode;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeAttendenceInfo> employeeAttendenceInfos = new LinkedHashSet<>();

}