package com.example.student_management.model;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "management_class")
@Entity(name = "management_class")
public class ManagementClass {
    @Id
    @SequenceGenerator(name = "management_class_sequence", sequenceName = "management_class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "management_class_sequence")
    @Column(name = "management_class_id")
    private Long managementClassId;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
//    @Column(nullable = false)
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "Lecturer_id", referencedColumnName = "lecturer_id")
//    @OneToOne(mappedBy = "managementClass")
    private Lecturer lecturer;
    @OneToMany(mappedBy = "managementClass", cascade = CascadeType.ALL)
    private List<Student> students;


    public ManagementClass() {
    }

    public ManagementClass(Long managementClassId, String name, Faculty faculty, Lecturer lecturer, List<Student> students) {
        this.managementClassId = managementClassId;
        this.name = name;
        this.faculty = faculty;
        this.lecturer = lecturer;
        this.students = students;
    }

    public Long getManagementClassId() {
        return this.managementClassId;
    }

    public void setManagementClassId(Long managementClassId) {
        this.managementClassId = managementClassId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return this.faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Lecturer getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ManagementClass managementClassId(Long managementClassId) {
        setManagementClassId(managementClassId);
        return this;
    }

    public ManagementClass name(String name) {
        setName(name);
        return this;
    }

    public ManagementClass faculty(Faculty faculty) {
        setFaculty(faculty);
        return this;
    }

    public ManagementClass lecturer(Lecturer lecturer) {
        setLecturer(lecturer);
        return this;
    }

    public ManagementClass students(List<Student> students) {
        setStudents(students);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ManagementClass)) {
            return false;
        }
        ManagementClass managementClass = (ManagementClass) o;
        return Objects.equals(managementClassId, managementClass.managementClassId) && Objects.equals(name, managementClass.name) && Objects.equals(faculty, managementClass.faculty) && Objects.equals(lecturer, managementClass.lecturer) && Objects.equals(students, managementClass.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managementClassId, name, faculty, lecturer, students);
    }

    @Override
    public String toString() {
        return "{" +
            " managementClassId='" + getManagementClassId() + "'" +
            ", name='" + getName() + "'" +
            ", faculty='" + getFaculty() + "'" +
            ", lecturer='" + getLecturer() + "'" +
            ", students='" + getStudents() + "'" +
            "}";
    }
    
}
