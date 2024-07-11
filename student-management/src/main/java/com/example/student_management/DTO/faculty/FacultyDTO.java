package com.example.student_management.dto.faculty;
import java.util.Objects;

public class FacultyDTO {
    public Long id;
    public String name;


    public FacultyDTO() {
    }

    public FacultyDTO(Long id, String name) {
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

    public FacultyDTO id(Long id) {
        setId(id);
        return this;
    }

    public FacultyDTO name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FacultyDTO)) {
            return false;
        }
        FacultyDTO facultyDTO = (FacultyDTO) o;
        return Objects.equals(id, facultyDTO.id) && Objects.equals(name, facultyDTO.name);
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
