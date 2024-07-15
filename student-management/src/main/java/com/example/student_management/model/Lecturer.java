package com.example.student_management.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lecturer")
public class Lecturer extends Person {
    @Id
    @SequenceGenerator(name = "lecturer_sequence", sequenceName = "lecturer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_sequence")
    @Column(name = "lecturer_id")
    private Long lecturerId;

    @Column(name = "faculty_id", nullable = false)
    private Long facultyId;

    @OneToOne(mappedBy = "lecturer")
    private ManagementClass managementClass;

    @OneToMany(mappedBy = "lecturer")
    private List<SubjectClass> subjectclasses;


    public Lecturer() {
    }

    public Lecturer(Long lecturerId, Long facultyId, ManagementClass managementClass, List<SubjectClass> subjectclasses) {
        this.lecturerId = lecturerId;
        this.facultyId = facultyId;
        this.managementClass = managementClass;
        this.subjectclasses = subjectclasses;
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

    public ManagementClass getManagementClass() {
        return this.managementClass;
    }

    public void setManagementClass(ManagementClass managementClass) {
        this.managementClass = managementClass;
    }

    public List<SubjectClass> getSubjectclasses() {
        return this.subjectclasses;
    }

    public void setSubjectclasses(List<SubjectClass> subjectclasses) {
        this.subjectclasses = subjectclasses;
    }

    public Lecturer lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    public Lecturer facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public Lecturer managementClass(ManagementClass managementClass) {
        setManagementClass(managementClass);
        return this;
    }

    public Lecturer subjectclasses(List<SubjectClass> subjectclasses) {
        setSubjectclasses(subjectclasses);
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
        return Objects.equals(lecturerId, lecturer.lecturerId) && Objects.equals(facultyId, lecturer.facultyId) && Objects.equals(managementClass, lecturer.managementClass) && Objects.equals(subjectclasses, lecturer.subjectclasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerId, facultyId, managementClass, subjectclasses);
    }

    @Override
    public String toString() {
        return "{" +
            " lecturerId='" + getLecturerId() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            // ", managementClass='" + getManagementClass() + "'" +
            // ", subjectclasses='" + getSubjectclasses() + "'" +
            "}";
    }
    
}
