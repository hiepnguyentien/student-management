package com.example.student_management.dto.managementClass;
import java.util.Objects;

public class ManagementClassDTO {
    public Long id;
    public String name;
    public Long facultyId;
    public Long lecturerId;

    public ManagementClassDTO() {
    }

    public ManagementClassDTO(Long id, String name, Long facultyId, Long lecturerId) {
        this.id = id;
        this.name = name;
        this.facultyId = facultyId;
        this.lecturerId = lecturerId;
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

    public Long getFacultyId() {
        return this.facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public Long getLecturerId() {
        return this.lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public ManagementClassDTO id(Long id) {
        setId(id);
        return this;
    }

    public ManagementClassDTO name(String name) {
        setName(name);
        return this;
    }

    public ManagementClassDTO facultyId(Long facultyId) {
        setFacultyId(facultyId);
        return this;
    }

    public ManagementClassDTO lecturerId(Long lecturerId) {
        setLecturerId(lecturerId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ManagementClassDTO)) {
            return false;
        }
        ManagementClassDTO managementDTO = (ManagementClassDTO) o;
        return Objects.equals(id, managementDTO.id) && Objects.equals(name, managementDTO.name) && Objects.equals(facultyId, managementDTO.facultyId) && Objects.equals(lecturerId, managementDTO.lecturerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, facultyId, lecturerId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", facultyId='" + getFacultyId() + "'" +
            ", lecturerId='" + getLecturerId() + "'" +
            "}";
    }
    
}
