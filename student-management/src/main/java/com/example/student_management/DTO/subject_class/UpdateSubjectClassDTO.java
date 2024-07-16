package com.example.student_management.dto.subjectClass;
import java.util.Objects;

public class UpdateSubjectClassDTO {
    public Long id;
    public String name;
    public Long lecturerId;
    public Long subjectId;

    public UpdateSubjectClassDTO() {
    }

    public UpdateSubjectClassDTO(Long id, String name, Long lecturerId, Long subjectId) {
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

    public UpdateSubjectClassDTO id(Long id) {
        setId(id);
        return this;
    }

    public UpdateSubjectClassDTO name(String name) {
        setName(name);
        return this;
    }

    public UpdateSubjectClassDTO lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    public UpdateSubjectClassDTO subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateSubjectClassDTO)) {
            return false;
        }
        UpdateSubjectClassDTO updateSubjectClassDTO = (UpdateSubjectClassDTO) o;
        return Objects.equals(id, updateSubjectClassDTO.id) && Objects.equals(name, updateSubjectClassDTO.name) && Objects.equals(lecturerId, updateSubjectClassDTO.lecturerId) && Objects.equals(subjectId, updateSubjectClassDTO.subjectId);
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
