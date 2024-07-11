package com.example.student_management.dto.faculty;
import java.util.Objects;

public class AddNewFacultyDTO {
    public String name;

    public AddNewFacultyDTO() {
    }

    public AddNewFacultyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddNewFacultyDTO name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AddNewFacultyDTO)) {
            return false;
        }
        AddNewFacultyDTO addNewFacultyDTO = (AddNewFacultyDTO) o;
        return Objects.equals(name, addNewFacultyDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }

}
