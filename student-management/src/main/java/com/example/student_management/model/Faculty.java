package com.example.student_management.model;
import java.util.HashSet;
import java.util.Objects;

import java.util.Set;

import jakarta.persistence.*;

@Table(name = "faculty")
@Entity(name = "faculty")
public class Faculty {
    @Id
    @SequenceGenerator(name = "faculty_sequence", sequenceName = "faculty_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_sequence")    
    @Column(name = "faculty_id")
    private String facultyId;
    private String facultyName;
    @ManyToMany
    @JoinTable(
        name = "subject_faculty",
        joinColumns = @JoinColumn(name = "faculty_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();
    @OneToMany(mappedBy = "faculty")
    private Set<ManagementClass> managementClasses = new HashSet<>();


    public Faculty(String facultyId, String facultyName, Set<Subject> subjects, Set<ManagementClass> managementClasses) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.subjects = subjects;
        this.managementClasses = managementClasses;
    }

    public Set<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<ManagementClass> getManagementClasses() {
        return this.managementClasses;
    }

    public void setManagementClasses(Set<ManagementClass> managementClasses) {
        this.managementClasses = managementClasses;
    }

    public Faculty subjects(Set<Subject> subjects) {
        setSubjects(subjects);
        return this;
    }

    public Faculty managementClasses(Set<ManagementClass> managementClasses) {
        setManagementClasses(managementClasses);
        return this;
    }

    public Faculty() {
    }

    public Faculty(String facultyId, String facultyName) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public String getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Faculty facultyId(String facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public Faculty facultyName(String facultyName) {
        setFacultyName(facultyName);
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
        return Objects.equals(facultyId, faculty.facultyId) && Objects.equals(facultyName, faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, facultyName);
    }

    @Override
    public String toString() {
        return "{" +
            " facultyId='" + getFacultyId() + "'" +
            ", facultyName='" + getFacultyName() + "'" +
            "}";
    }
    
}
