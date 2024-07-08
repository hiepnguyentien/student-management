package com.example.student_management.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

@Table(name = "student")
@Entity(name = "Student")
public class Student extends Person {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "student_id")
    private Long studentId;
    private LocalDate EnrollDate;
    @ManyToOne
    @JoinColumn(
        name = "management_class_id"
    )
    private String managementClass;
    private String faculty;
    private Long classId;
    private Long facultyId;
    private Integer Batch;
    @OneToMany(mappedBy = "student")
    private Set<Score> scores = new HashSet<>();

    public Student(Long studentId, LocalDate EnrollDate, String managementClass, String faculty, Long classId, Long facultyId, Integer Batch, Set<Score> scores) {
        this.studentId = studentId;
        this.EnrollDate = EnrollDate;
        this.managementClass = managementClass;
        this.faculty = faculty;
        this.classId = classId;
        this.facultyId = facultyId;
        this.Batch = Batch;
        this.scores = scores;
    }

    public Set<Score> getScores() {
        return this.scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public Student scores(Set<Score> scores) {
        setScores(scores);
        return this;
    }


    public Student() {
    }

    public Student(Long studentId, LocalDate EnrollDate, String managementClass, String faculty, Long classId,
            Long facultyId, Integer Batch) {
        this.studentId = studentId;
        this.EnrollDate = EnrollDate;
        this.managementClass = managementClass;
        this.faculty = faculty;
        this.classId = classId;
        this.facultyId = facultyId;
        this.Batch = Batch;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getEnrollDate() {
        return this.EnrollDate;
    }

    public void setEnrollDate(LocalDate EnrollDate) {
        this.EnrollDate = EnrollDate;
    }

    public String getManagementClass() {
        return this.managementClass;
    }

    public void setManagementClass(String managementClass) {
        this.managementClass = managementClass;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getBatch() {
        if (getEnrollDate() == null) {
            return 0;
        }
        return getEnrollDate().getYear() - 1966 + 1;
    }

    public void setBatch(Integer Batch) {
        this.Batch = Batch;
    }

    public Student studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public Student EnrollDate(LocalDate EnrollDate) {
        setEnrollDate(EnrollDate);
        return this;
    }

    public Student managementClass(String managementClass) {
        setManagementClass(managementClass);
        return this;
    }

    public Student faculty(String faculty) {
        setFaculty(faculty);
        return this;
    }

    public Student classId(Long classId) {
        setClassId(classId);
        return this;
    }

    public Student facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public Student Batch(Integer Batch) {
        setBatch(Batch);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(EnrollDate, student.EnrollDate)
                && Objects.equals(managementClass, student.managementClass) && Objects.equals(faculty, student.faculty)
                && Objects.equals(classId, student.classId) && Objects.equals(facultyId, student.facultyId)
                && Objects.equals(Batch, student.Batch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, EnrollDate, managementClass, faculty, classId, facultyId, Batch);
    }

    @Override
    public String toString() {
        return "{" +
                " studentId='" + getStudentId() + "'" +
                ", EnrollDate='" + getEnrollDate() + "'" +
                ", managementClass='" + getManagementClass() + "'" +
                ", faculty='" + getFaculty() + "'" +
                ", classId='" + getClassId() + "'" +
                ", facultyId='" + getFacultyId() + "'" +
                ", Batch='" + getBatch() + "'" +
                "}";
    }

}
