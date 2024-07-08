package com.example.student_management.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "lecturer")
@Entity(name = "lecturer")
public class Lecturer extends Person{
    @Id
    @SequenceGenerator(name = "lecturer_sequence", sequenceName = "lecturer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_sequence")
    @Column(name = "lecturer_id")
    private Long lecturerId;
    @Column(nullable = false)
    private Long facultyId;
//    @OneToOne(mappedBy = "lecturer")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "management_class_id", referencedColumnName = "managementClassId")
    private ManagementClass managementClass;
    @OneToMany(mappedBy = "lecturer")
    private Set<SubjectClass> subjectClasses = new HashSet<>();

    public Lecturer() {
    }

    public Lecturer(Long lecturerId, Long facultyId, ManagementClass managementClass, Set<SubjectClass> subjectClasses) {
        this.lecturerId = lecturerId;
        this.facultyId = facultyId;
        this.managementClass = managementClass;
        this.subjectClasses = subjectClasses;
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

    public Set<SubjectClass> getSubjectClasses() {
        return this.subjectClasses;
    }

    public void setSubjectClasses(Set<SubjectClass> subjectClasses) {
        this.subjectClasses = subjectClasses;
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

    public Lecturer subjectClasses(Set<SubjectClass> subjectClasses) {
        setSubjectClasses(subjectClasses);
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
        return Objects.equals(lecturerId, lecturer.lecturerId) && Objects.equals(facultyId, lecturer.facultyId) && Objects.equals(managementClass, lecturer.managementClass) && Objects.equals(subjectClasses, lecturer.subjectClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerId, facultyId, managementClass, subjectClasses);
    }

    @Override
    public String toString() {
        return "{" +
            " lecturerId='" + getLecturerId() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            ", managementClass='" + getManagementClass() + "'" +
            ", subjectClasses='" + getSubjectClasses() + "'" +
            "}";
    }

}
