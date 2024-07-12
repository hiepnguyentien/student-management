package com.example.student_management.dto.score;
import java.util.Objects;

import com.example.student_management.model.Grade;
import jakarta.validation.constraints.Size;

public class ScoreDTO {
    public Long scoreId;
    public Long subjectClassId;
    public Long studentId;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float attendanceScore;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float midTermScore;
    @Size(min = 0, max = 10, message = "Điểm phải nằm trong khoảng từ 0 đến 10")
    public Float endTermScore;
    @Size(min = 1, max = 3, message = "Học kỳ phải nằm trong khoảng từ 1 đến 3")
    public Integer semester;
    public Float processScore;
    public Float finalScore;
    public Float GPA;
    public Grade grade;


    public ScoreDTO() {
    }

    public ScoreDTO(Long scoreId, Long subjectClassId, Long studentId, Float attendanceScore, 
                    Float midTermScore, Float endTermScore, Integer semester, 
                    Float processScore, Float finalScore, Float GPA, Grade grade) {
        this.scoreId = scoreId;
        this.subjectClassId = subjectClassId;
        this.studentId = studentId;
        this.attendanceScore = attendanceScore;
        this.midTermScore = midTermScore;
        this.endTermScore = endTermScore;
        this.semester = semester;
        this.processScore = processScore;
        this.finalScore = finalScore;
        this.GPA = GPA;
        this.grade = grade;
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

        public Float getProcessScore() {
        return (getAttendanceScore() + getMidTermScore()) / 2;
    }

    public Float getFinalScore() {
        return getProcessScore() * 0.3f + getEndTermScore() * 0.7f;
    }

    public Float getGPA(){
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

    public Grade getGrade(){
        return Grade.fromScore(getFinalScore());
    }

    public ScoreDTO scoreId(Long scoreId) {
        setScoreId(scoreId);
        return this;
    }

    public ScoreDTO studentId(Long studentId) {
        setStudentId(studentId);
        return this;
    }

    public ScoreDTO attendanceScore(Float attendanceScore) {
        setAttendanceScore(attendanceScore);
        return this;
    }

    public ScoreDTO midTermScore(Float midTermScore) {
        setMidTermScore(midTermScore);
        return this;
    }

    public ScoreDTO endTermScore(Float endTermScore) {
        setEndTermScore(endTermScore);
        return this;
    }

    public ScoreDTO subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
        return this;
    }

    public ScoreDTO semester(Integer semester) {
        setSemester(semester);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ScoreDTO)) {
            return false;
        }
        ScoreDTO scoreDTO = (ScoreDTO) o;
        return Objects.equals(scoreId, scoreDTO.scoreId) && Objects.equals(studentId, scoreDTO.studentId) && Objects.equals(attendanceScore, scoreDTO.attendanceScore) && Objects.equals(midTermScore, scoreDTO.midTermScore) && Objects.equals(endTermScore, scoreDTO.endTermScore) && Objects.equals(subjectClassId, scoreDTO.subjectClassId) && Objects.equals(semester, scoreDTO.semester);
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