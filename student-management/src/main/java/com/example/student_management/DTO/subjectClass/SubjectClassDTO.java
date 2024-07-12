package com.example.student_management.dto.subjectClass;
import java.util.Objects;

public class SubjectClassDTO {
    public Long id;
    public String name;
    public Long lecturerId;
    public Long subjectId;

    public SubjectClassDTO() {
    }

    public SubjectClassDTO(Long id, String name, Long lecturerId, Long subjectId) {
        this.id = id;
        this.name = name;
        this.lecturerId = lecturerId;
        this.subjectId = subjectId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLecturerId() {
        return this.lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public SubjectClassDTO id(Long id) {
        setId(id);
        return this;
    }

    public SubjectClassDTO name(String name) {
        setName(name);
        return this;
    }

    public SubjectClassDTO lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    public SubjectClassDTO subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubjectClassDTO)) {
            return false;
        }
        SubjectClassDTO subjectClassDTO = (SubjectClassDTO) o;
        return Objects.equals(id, subjectClassDTO.id) && Objects.equals(name, subjectClassDTO.name) && Objects.equals(lecturerId, subjectClassDTO.lecturerId) && Objects.equals(subjectId, subjectClassDTO.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lecturerId, subjectId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", lecturerId='" + getLecturerId() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            "}";
    }

}
