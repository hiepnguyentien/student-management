package com.example.student_management.dto.subject;

public class AddSubjectDTO {
    public String name;
    public String description;
    public Integer credit;

    public AddSubjectDTO() {
    }

    public AddSubjectDTO(String name, String description, Integer credit) {
        this.name = name;
        this.description = description;
        this.credit = credit;
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

    public AddSubjectDTO name(String name) {
        setName(name);
        return this;
    }

    public AddSubjectDTO description(String description) {
        setDescription(description);
        return this;
    }

    public AddSubjectDTO credit(Integer credit) {
        setCredit(credit);
        return this;
    }
}
