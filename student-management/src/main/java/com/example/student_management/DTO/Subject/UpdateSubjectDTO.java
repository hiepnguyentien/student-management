package com.example.student_management.dto.subject;
import java.util.Objects;

public class UpdateSubjectDTO {
    public Long id;
    public String name;
    public String description;
    public Integer credit;

    public UpdateSubjectDTO() {
    }

    public UpdateSubjectDTO(Long id, String name, String description, Integer credit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credit = credit;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public UpdateSubjectDTO id(Long id) {
        setId(id);
        return this;
    }

    public UpdateSubjectDTO name(String name) {
        setName(name);
        return this;
    }

    public UpdateSubjectDTO description(String description) {
        setDescription(description);
        return this;
    }

    public UpdateSubjectDTO credit(Integer credit) {
        setCredit(credit);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateSubjectDTO)) {
            return false;
        }
        UpdateSubjectDTO updateSubjectDTO = (UpdateSubjectDTO) o;
        return Objects.equals(id, updateSubjectDTO.id) && Objects.equals(name, updateSubjectDTO.name) && Objects.equals(description, updateSubjectDTO.description) && Objects.equals(credit, updateSubjectDTO.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, credit);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", credit='" + getCredit() + "'" +
            "}";
    }
    
}
