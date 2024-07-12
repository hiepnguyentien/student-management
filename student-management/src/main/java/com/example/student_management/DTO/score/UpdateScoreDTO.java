package com.example.student_management.dto.score;
import java.util.Objects;

import jakarta.validation.constraints.Size;

public class UpdateScoreDTO {
    public Long scoreId;
    public Long studentId;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float attendanceScore;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float midTermScore;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float endTermScore;
    public Long subjectClassId;
    @Size(min = 1, max = 3, message = "Học kỳ phải nằm trong khoảng từ 1 đến 3")
    public Integer semester;


    public UpdateScoreDTO() {
    }

    public UpdateScoreDTO(Long scoreId, Long studentId, Float attendanceScore, Float midTermScore, Float endTermScore, Long subjectClassId, Integer semester) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.attendanceScore = attendanceScore;
        this.midTermScore = midTermScore;
        this.endTermScore = endTermScore;
        this.subjectClassId = subjectClassId;
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

    public UpdateScoreDTO scoreId(Long scoreId) {
        setScoreId(scoreId);
        return this;
    }

    public UpdateScoreDTO studentId(Long studentId) {
        setStudentId(studentId);
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

    public UpdateScoreDTO subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
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
        return Objects.equals(scoreId, updateScoreDTO.scoreId) && Objects.equals(studentId, updateScoreDTO.studentId) && Objects.equals(attendanceScore, updateScoreDTO.attendanceScore) && Objects.equals(midTermScore, updateScoreDTO.midTermScore) && Objects.equals(endTermScore, updateScoreDTO.endTermScore) && Objects.equals(subjectClassId, updateScoreDTO.subjectClassId) && Objects.equals(semester, updateScoreDTO.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, studentId, attendanceScore, midTermScore, endTermScore, subjectClassId, semester);
    }

    @Override
    public String toString() {
        return "{" +
            " scoreId='" + getScoreId() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", attendanceScore='" + getAttendanceScore() + "'" +
            ", midTermScore='" + getMidTermScore() + "'" +
            ", endTermScore='" + getEndTermScore() + "'" +
            ", subjectClassId='" + getSubjectClassId() + "'" +
            ", semester='" + getSemester() + "'" +
            "}";
    }
    
    
}
