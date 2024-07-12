package com.example.student_management.dto.subjectClass;
import java.util.Objects;

public class AddSubjectClassDTO {
    public String name;
    public Long lecturerId;
    public Long subjectId;

    public AddSubjectClassDTO() {
    }

    public AddSubjectClassDTO(String name, Long lecturerId, Long subjectId) {
        this.name = name;
        this.lecturerId = lecturerId;
        this.subjectId = subjectId;
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

    public AddSubjectClassDTO name(String name) {
        setName(name);
        return this;
    }

    public AddSubjectClassDTO lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    public AddSubjectClassDTO subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AddSubjectClassDTO)) {
            return false;
        }
        AddSubjectClassDTO addSubjectClassDTO = (AddSubjectClassDTO) o;
        return Objects.equals(name, addSubjectClassDTO.name) && Objects.equals(lecturerId, addSubjectClassDTO.lecturerId) && Objects.equals(subjectId, addSubjectClassDTO.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lecturerId, subjectId);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", lecturerId='" + getLecturerId() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            "}";
    }

}
