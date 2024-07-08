package com.example.student_management.model;
import java.util.Objects;

public class Subject_Faculty {
    private Long subjectId;
    private Long facultyId;

    public Subject_Faculty() {
    }

    public Subject_Faculty(Long subjectId, Long facultyId) {
        this.subjectId = subjectId;
        this.facultyId = facultyId;
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Subject_Faculty subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    public Subject_Faculty facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Subject_Faculty)) {
            return false;
        }
        Subject_Faculty subject_Faculty = (Subject_Faculty) o;
        return Objects.equals(subjectId, subject_Faculty.subjectId) && Objects.equals(facultyId, subject_Faculty.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, facultyId);
    }

    @Override
    public String toString() {
        return "{" +
            " subjectId='" + getSubjectId() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            "}";
    }
    
}
