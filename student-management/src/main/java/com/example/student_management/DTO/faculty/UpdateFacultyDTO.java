package com.example.student_management.dto.faculty;
import java.util.Objects;

public class UpdateFacultyDTO {
    public Long id;
    public String name;

    public UpdateFacultyDTO() {
    }

    public UpdateFacultyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public UpdateFacultyDTO id(Long id) {
        setId(id);
        return this;
    }

    public UpdateFacultyDTO name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateFacultyDTO)) {
            return false;
        }
        UpdateFacultyDTO updateFacultyDTO = (UpdateFacultyDTO) o;
        return Objects.equals(id, updateFacultyDTO.id) && Objects.equals(name, updateFacultyDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
