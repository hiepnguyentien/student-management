package com.example.student_management.dto.score;
import java.util.Objects;

import jakarta.validation.constraints.Size;

public class AddScoreDTO {
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


    public AddScoreDTO() {
    }

    public AddScoreDTO(Long studentId, Float attendanceScore, Float midTermScore, Float endTermScore, Long subjectClassId, Integer semester) {
        this.studentId = studentId;
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

    public AddScoreDTO studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public AddScoreDTO attendanceScore(Float attendanceScore) {
        setAttendanceScore(attendanceScore);
        return this;
    }

    public AddScoreDTO midTermScore(Float midTermScore) {
        setMidTermScore(midTermScore);
        return this;
    }

    public AddScoreDTO endTermScore(Float endTermScore) {
        setEndTermScore(endTermScore);
        return this;
    }

    public AddScoreDTO subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
        return this;
    }

    public AddScoreDTO semester(Integer semester) {
        setSemester(semester);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AddScoreDTO)) {
            return false;
        }
        AddScoreDTO addScoreDTO = (AddScoreDTO) o;
        return Objects.equals(studentId, addScoreDTO.studentId) && Objects.equals(attendanceScore, addScoreDTO.attendanceScore) && Objects.equals(midTermScore, addScoreDTO.midTermScore) && Objects.equals(endTermScore, addScoreDTO.endTermScore) && Objects.equals(subjectClassId, addScoreDTO.subjectClassId) && Objects.equals(semester, addScoreDTO.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, attendanceScore, midTermScore, endTermScore, subjectClassId, semester);
    }

    @Override
    public String toString() {
        return "{" +
            " studentId='" + getStudentId() + "'" +
            ", attendanceScore='" + getAttendanceScore() + "'" +
            ", midTermScore='" + getMidTermScore() + "'" +
            ", endTermScore='" + getEndTermScore() + "'" +
            ", subjectClassId='" + getSubjectClassId() + "'" +
            ", semester='" + getSemester() + "'" +
            "}";
    }
    
}
