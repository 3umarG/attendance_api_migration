package com.example.attendance_migration.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_attendence_info", schema = "migrations")
public class EmployeeAttendenceInfo {
    @EmbeddedId
    private EmployeeAttendenceInfoId id;

    @MapsId("empId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @Column(name = "day_description", length = Integer.MAX_VALUE)
    private String dayDescription;

    @Column(name = "is_attendent")
    private Boolean isAttendent;

}