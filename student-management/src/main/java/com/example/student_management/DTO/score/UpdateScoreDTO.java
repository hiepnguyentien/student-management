package com.example.student_management.dto.score;
import java.util.Objects;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public class UpdateScoreDTO {
    public Long scoreId;
    public Long studentId;
    public Long subjectClassId;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    public Float attendanceScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    public Float midTermScore;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    public Float endTermScore;
    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "3.0", inclusive = true)
    public Integer semester;


    public UpdateScoreDTO() {
    }

    public UpdateScoreDTO(Long scoreId, Long studentId, Long subjectClassId, Float attendanceScore, Float midTermScore, Float endTermScore, Integer semester) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectClassId = subjectClassId;
        this.attendanceScore = attendanceScore;
        this.midTermScore = midTermScore;
        this.endTermScore = endTermScore;
        this.semester = semester;
    }

    public Long getScoreId() {
        return this.scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectClassId() {
        return this.subjectClassId;
    }

    public void setSubjectClassId(Long subjectClassId) {
        this.subjectClassId = subjectClassId;
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

    public Integer getSemester() {
        return this.semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public UpdateScoreDTO scoreId(Long scoreId) {
        setScoreId(scoreId);
        return this;
    }

    public UpdateScoreDTO studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public UpdateScoreDTO subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
        return this;
    }

    public UpdateScoreDTO attendanceScore(Float attendanceScore) {
        setAttendanceScore(attendanceScore);
        return this;
    }

    public UpdateScoreDTO midTermScore(Float midTermScore) {
        setMidTermScore(midTermScore);
        return this;
    }

    public UpdateScoreDTO endTermScore(Float endTermScore) {
        setEndTermScore(endTermScore);
        return this;
    }

    public UpdateScoreDTO semester(Integer semester) {
        setSemester(semester);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateScoreDTO)) {
            return false;
        }
        UpdateScoreDTO updateScoreDTO = (UpdateScoreDTO) o;
        return Objects.equals(scoreId, updateScoreDTO.scoreId) && Objects.equals(studentId, updateScoreDTO.studentId) && Objects.equals(subjectClassId, updateScoreDTO.subjectClassId) && Objects.equals(attendanceScore, updateScoreDTO.attendanceScore) && Objects.equals(midTermScore, updateScoreDTO.midTermScore) && Objects.equals(endTermScore, updateScoreDTO.endTermScore) && Objects.equals(semester, updateScoreDTO.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, studentId, subjectClassId, attendanceScore, midTermScore, endTermScore, semester);
    }

    @Override
    public String toString() {
        return "{" +
            " scoreId='" + getScoreId() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", subjectClassId='" + getSubjectClassId() + "'" +
            ", attendanceScore='" + getAttendanceScore() + "'" +
            ", midTermScore='" + getMidTermScore() + "'" +
            ", endTermScore='" + getEndTermScore() + "'" +
            ", semester='" + getSemester() + "'" +
            "}";
    }

}
