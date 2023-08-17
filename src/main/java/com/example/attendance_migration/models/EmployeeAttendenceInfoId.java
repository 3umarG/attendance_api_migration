package com.example.attendance_migration.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EmployeeAttendenceInfoId implements Serializable {
    private static final long serialVersionUID = 3428679079103785581L;
    @Column(name = "emp_id", nullable = false)
    private Integer empId;

    @Column(name = "day", nullable = false)
    private LocalDate day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeAttendenceInfoId entity = (EmployeeAttendenceInfoId) o;
        return Objects.equals(this.empId, entity.empId) &&
               Objects.equals(this.day, entity.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, day);
    }

}