package com.example.student_management.model;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "score")
@Entity(name = "score")
public class Score {
    private Long studentId;
    private Long subjectId;
    private Float attendanceScore;
    private Float midTermScore;
    private Float endTermScore;
    private Long subjectClassId;
    private Integer semester;


    public Score() {
    }

    public Score(Long studentId, Long subjectId, Float attendanceScore, Float midTermScore, Float endTermScore, Long subjectClassId, Integer semester) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.attendanceScore = attendanceScore;
        this.midTermScore = midTermScore;
        this.endTermScore = endTermScore;
        this.subjectClassId = subjectClassId;
        this.semester = semester;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public Long getSubjectClassId() {
        return this.subjectClassId;
    }

    public void setSubjectClassId(Long subjectClassId) {
        this.subjectClassId = subjectClassId;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Float getProcessScore() {
        return (attendanceScore + midTermScore) / 2;
    }

    public Float getFinalScore() {
        return getProcessScore() * 0.3f + endTermScore * 0.7f;
    }

    public Float getDiemHe4() {
        float finalScore = getFinalScore();
        if (finalScore >= 8.5f)
            return 4f;
        else if (finalScore >= 8.0f)
            return 3.5f;
        else if (finalScore >= 7.0f)
            return 3.0f;
        else if (finalScore >= 6.5f)
            return 2.5f;
        else if (finalScore >= 5.5f)
            return 2.0f;
        else if (finalScore >= 5.0f)
            return 1.5f;
        else if (finalScore >= 4.0f)
            return 1.0f;
        else
            return 0f;
    }

    public Score studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public Score subjectId(Long subjectId) {
        setSubjectId(subjectId);
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

    public Score subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
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
        return Objects.equals(studentId, score.studentId) && Objects.equals(subjectId, score.subjectId) && Objects.equals(attendanceScore, score.attendanceScore) && Objects.equals(midTermScore, score.midTermScore) && Objects.equals(endTermScore, score.endTermScore) && Objects.equals(subjectClassId, score.subjectClassId) && Objects.equals(semester, score.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId, attendanceScore, midTermScore, endTermScore, subjectClassId, semester);
    }

    @Override
    public String toString() {
        return "{" +
            " student='" + getStudentId() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            ", attendanceScore='" + getAttendanceScore() + "'" +
            ", midTermScore='" + getMidTermScore() + "'" +
            ", endTermScore='" + getEndTermScore() + "'" +
            ", subjectClass='" + getSubjectClassId() + "'" +
            ", semester='" + getSemester() + "'" +
            "}";
    }
    
}
