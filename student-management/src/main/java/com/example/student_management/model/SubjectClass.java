package com.example.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Table(name = "subject_class")
@Entity(name = "subject_class")
public class SubjectClass {
    private Long subjectClassId;
    private Long subjectId;
    private Long lecturerId;

    public SubjectClass() {
    }

    public SubjectClass(Long subjectClassId, Long subjectId, Long lecturerId) {
        this.subjectClassId = subjectClassId;
        this.subjectId = subjectId;
        this.lecturerId = lecturerId;
    }

    public Long getSubjectClassId() {
        return this.subjectClassId;
    }

    public void setSubjectClassId(Long subjectClassId) {
        this.subjectClassId = subjectClassId;
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getLecturerId() {
        return this.lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public SubjectClass subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
        return this;
    }

    public SubjectClass subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    public SubjectClass lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubjectClass)) {
            return false;
        }
        SubjectClass subjectClass = (SubjectClass) o;
        return Objects.equals(subjectClassId, subjectClass.subjectClassId) && Objects.equals(subjectId, subjectClass.subjectId) && Objects.equals(lecturerId, subjectClass.lecturerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectClassId, subjectId, lecturerId);
    }

    @Override
    public String toString() {
        return "{" +
            " subjectClassId='" + getSubjectClassId() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            ", lecturerId='" + getLecturerId() + "'" +
            "}";
    }
    
}
