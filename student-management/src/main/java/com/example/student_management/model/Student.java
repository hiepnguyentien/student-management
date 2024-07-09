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
import java.util.List;
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
    private ManagementClass managementClass;
    private Integer Batch;
    @OneToMany(mappedBy = "student")
    private List<Score> scores;


    public Student() {
    }

    public Student(Long studentId, LocalDate EnrollDate, ManagementClass managementClass, Integer Batch, List<Score> scores) {
        this.studentId = studentId;
        this.EnrollDate = EnrollDate;
        this.managementClass = managementClass;
        this.Batch = Batch;
        this.scores = scores;
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

    public ManagementClass getManagementClass() {
        return this.managementClass;
    }

    public void setManagementClass(ManagementClass managementClass) {
        this.managementClass = managementClass;
    }

    public Integer getBatch() {
        return this.Batch;
    }

    public void setBatch(Integer Batch) {
        this.Batch = Batch;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Student studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public Student EnrollDate(LocalDate EnrollDate) {
        setEnrollDate(EnrollDate);
        return this;
    }

    public Student managementClass(ManagementClass managementClass) {
        setManagementClass(managementClass);
        return this;
    }

    public Student Batch(Integer Batch) {
        setBatch(Batch);
        return this;
    }

    public Student scores(List<Score> scores) {
        setScores(scores);
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
        return Objects.equals(studentId, student.studentId) && Objects.equals(EnrollDate, student.EnrollDate) && Objects.equals(managementClass, student.managementClass) && Objects.equals(Batch, student.Batch) && Objects.equals(scores, student.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, EnrollDate, managementClass, Batch, scores);
    }

    @Override
    public String toString() {
        return "{" +
            " studentId='" + getStudentId() + "'" +
            ", EnrollDate='" + getEnrollDate() + "'" +
            ", managementClass='" + getManagementClass() + "'" +
            ", Batch='" + getBatch() + "'" +
            ", scores='" + getScores() + "'" +
            "}";
    }
    
}
