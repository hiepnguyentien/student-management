package com.example.student_management.model;
import java.util.HashSet;
import java.util.Objects;
import java.util.List;

import java.util.Set;

import jakarta.persistence.*;

@Table(name = "faculty")
@Entity(name = "faculty")
public class Faculty {
    @Id
    @SequenceGenerator(name = "faculty_sequence", sequenceName = "faculty_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_sequence")    
    @Column(name = "faculty_id")
    private Long facultyId;
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
    @ManyToMany
    @JoinTable(
        name = "subject_faculty",
        joinColumns = @JoinColumn(name = "faculty_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
    @OneToMany(mappedBy = "faculty")
    private List<ManagementClass> managementClasses;


    public Faculty() {
    }

    public Faculty(Long facultyId, String facultyName, List<Subject> subjects, List<ManagementClass> managementClasses) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.subjects = subjects;
        this.managementClasses = managementClasses;
    }

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<ManagementClass> getManagementClasses() {
        return this.managementClasses;
    }

    public void setManagementClasses(List<ManagementClass> managementClasses) {
        this.managementClasses = managementClasses;
    }

    public Faculty facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public Faculty facultyName(String facultyName) {
        setFacultyName(facultyName);
        return this;
    }

    public Faculty subjects(List<Subject> subjects) {
        setSubjects(subjects);
        return this;
    }

    public Faculty managementClasses(List<ManagementClass> managementClasses) {
        setManagementClasses(managementClasses);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Faculty)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyId, faculty.facultyId) && Objects.equals(facultyName, faculty.facultyName) && Objects.equals(subjects, faculty.subjects) && Objects.equals(managementClasses, faculty.managementClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, facultyName, subjects, managementClasses);
    }

    @Override
    public String toString() {
        return "{" +
            " facultyId='" + getFacultyId() + "'" +
            ", facultyName='" + getFacultyName() + "'" +
            ", subjects='" + getSubjects() + "'" +
            ", managementClasses='" + getManagementClasses() + "'" +
            "}";
    }

}
