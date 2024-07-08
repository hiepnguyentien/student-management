package com.example.student_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.Objects;

public class Lecturer extends Person{
    @Id
    private Long lecturerId;
    @Column(nullable = false)
    private Long facultyId;
    private Long managementClassId;

    public Lecturer() {
    }

    public Lecturer(Long lecturerId, Long facultyId, Long managementClassId) {
        this.lecturerId = lecturerId;
        this.facultyId = facultyId;
        this.managementClassId = managementClassId;
    }

    public Long getLecturerId() {
        return this.lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getManagementClassId() {
        return this.managementClassId;
    }

    public void setManagementClassId(Long managementClassId) {
        this.managementClassId = managementClassId;
    }

    public Lecturer lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    public Lecturer facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public Lecturer managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Lecturer)) {
            return false;
        }
        Lecturer lecturer = (Lecturer) o;
        return Objects.equals(lecturerId, lecturer.lecturerId) && Objects.equals(facultyId, lecturer.facultyId) && Objects.equals(managementClassId, lecturer.managementClassId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerId, facultyId, managementClassId);
    }

    @Override
    public String toString() {
        return "{" +
            " lecturerId='" + getLecturerId() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            ", managementClassId='" + getManagementClassId() + "'" +
            "}";
    }
    
}
