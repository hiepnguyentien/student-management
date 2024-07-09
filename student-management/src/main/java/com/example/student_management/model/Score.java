package com.example.student_management.model;
import java.util.Objects;

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

@Table(name = "score")
@Entity(name = "score")
public class Score {
    @Id
    @SequenceGenerator(name = "score_sequence", sequenceName = "score_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_sequence")
    @Column(name = "score_id")
    private Long scoreId;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private Float attendanceScore;
    private Float midTermScore;
    private Float endTermScore;
    @ManyToOne
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;
    private Integer semester;


    public Score() {
    }

    public Score(Long scoreId, Student student, Float attendanceScore, Float midTermScore, Float endTermScore, SubjectClass subjectClass, Integer semester) {
        this.scoreId = scoreId;
        this.student = student;
        this.attendanceScore = attendanceScore;
        this.midTermScore = midTermScore;
        this.endTermScore = endTermScore;
        this.subjectClass = subjectClass;
        this.semester = semester;
    }

    public Long getScoreId() {
        return this.scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Float getAttendanceScore() {
        return this.attendanceScore;
    }

    public void setAttendanceScore(Float attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public Float getMidTermScore() {
        return this.midTermScore;
    }

    public void setMidTermScore(Float midTermScore) {
        this.midTermScore = midTermScore;
    }

    public Float getEndTermScore() {
        return this.endTermScore;
    }

    public void setEndTermScore(Float endTermScore) {
        this.endTermScore = endTermScore;
    }

    public SubjectClass getSubjectClass() {
        return this.subjectClass;
    }

    public void setSubjectClass(SubjectClass subjectClass) {
        this.subjectClass = subjectClass;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Score scoreId(Long scoreId) {
        setScoreId(scoreId);
        return this;
    }

    public Score student(Student student) {
        setStudent(student);
        return this;
    }

    public Score attendanceScore(Float attendanceScore) {
        setAttendanceScore(attendanceScore);
        return this;
    }

    public Score midTermScore(Float midTermScore) {
        setMidTermScore(midTermScore);
        return this;
    }

    public Score endTermScore(Float endTermScore) {
        setEndTermScore(endTermScore);
        return this;
    }

    public Score subjectClass(SubjectClass subjectClass) {
        setSubjectClass(subjectClass);
        return this;
    }

    public Score semester(Integer semester) {
        setSemester(semester);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Score)) {
            return false;
        }
        Score score = (Score) o;
        return Objects.equals(scoreId, score.scoreId) && Objects.equals(student, score.student) && Objects.equals(attendanceScore, score.attendanceScore) && Objects.equals(midTermScore, score.midTermScore) && Objects.equals(endTermScore, score.endTermScore) && Objects.equals(subjectClass, score.subjectClass) && Objects.equals(semester, score.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, student, attendanceScore, midTermScore, endTermScore, subjectClass, semester);
    }

    @Override
    public String toString() {
        return "{" +
            " scoreId='" + getScoreId() + "'" +
            ", student='" + getStudent() + "'" +
            ", attendanceScore='" + getAttendanceScore() + "'" +
            ", midTermScore='" + getMidTermScore() + "'" +
            ", endTermScore='" + getEndTermScore() + "'" +
            ", subjectClass='" + getSubjectClass() + "'" +
            ", semester='" + getSemester() + "'" +
            "}";
    }
    
}
