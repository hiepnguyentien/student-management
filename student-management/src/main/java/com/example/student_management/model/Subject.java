package com.example.student_management.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Table(name = "subject")
@Entity(name = "subject")
public class Subject {
    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Integer credit;
    @ManyToMany(mappedBy = "subjects")
    private Set<Faculty> faculties = new HashSet<>();
    @OneToMany(mappedBy = "subject")
    private List<SubjectClass> subjectClasses;


    public Subject() {
    }

    public Subject(Long subjectId, String name, String description, Integer credit, Set<Faculty> faculties) {
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
        this.credit = credit;
        this.faculties = faculties;
    }

    public Long getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public Set<Faculty> getFaculties() {
        return this.faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Subject subjectId(Long subjectId) {
        setSubjectId(subjectId);
        return this;
    }

    public Subject name(String name) {
        setName(name);
        return this;
    }

    public Subject description(String description) {
        setDescription(description);
        return this;
    }

    public Subject credit(Integer credit) {
        setCredit(credit);
        return this;
    }

    public Subject faculties(Set<Faculty> faculties) {
        setFaculties(faculties);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Subject)) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId) && Objects.equals(name, subject.name) && Objects.equals(description, subject.description) && Objects.equals(credit, subject.credit) && Objects.equals(faculties, subject.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, description, credit, faculties);
    }

    @Override
    public String toString() {
        return "{" +
            " subjectId='" + getSubjectId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", credit='" + getCredit() + "'" +
            ", faculties='" + getFaculties() + "'" +
            "}";
    }
    
}
