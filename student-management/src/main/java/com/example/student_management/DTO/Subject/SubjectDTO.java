package com.example.student_management.dto.Subject;
import java.util.Objects;

public class SubjectDTO {
    public Long id;
    public String name;
    public String description;
    public Integer credit;


    public SubjectDTO() {
    }

    public SubjectDTO(Long id, String name, String description, Integer credit) {
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

    public SubjectDTO id(Long id) {
        setId(id);
        return this;
    }

    public SubjectDTO name(String name) {
        setName(name);
        return this;
    }

    public SubjectDTO description(String description) {
        setDescription(description);
        return this;
    }

    public SubjectDTO credit(Integer credit) {
        setCredit(credit);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubjectDTO)) {
            return false;
        }
        SubjectDTO subjectDTO = (SubjectDTO) o;
        return Objects.equals(id, subjectDTO.id) && Objects.equals(name, subjectDTO.name) && Objects.equals(description, subjectDTO.description) && Objects.equals(credit, subjectDTO.credit);
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
