package com.example.student_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "subject_class")
@Entity(name = "subject_class")
public class SubjectClass {
    @Id
    @SequenceGenerator(name = "subject_class_sequence", sequenceName = "subject_class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_class_sequence")
    @Column(name = "subject_class_id")
    private Long subjectClassId;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @OneToMany(mappedBy = "subjectClass")
    private List<Score> scores;

    public SubjectClass() {
    }

    public SubjectClass(Long subjectClassId, Subject subject, Lecturer lecturer) {
        this.subjectClassId = subjectClassId;
        this.subject = subject;
        this.lecturer = lecturer;
    }

    public Long getSubjectClassId() {
        return this.subjectClassId;
    }

    public void setSubjectClassId(Long subjectClassId) {
        this.subjectClassId = subjectClassId;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Lecturer getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public SubjectClass subjectClassId(Long subjectClassId) {
        setSubjectClassId(subjectClassId);
        return this;
    }

    public SubjectClass subject(Subject subject) {
        setSubject(subject);
        return this;
    }

    public SubjectClass lecturer(Lecturer lecturer) {
        setLecturer(lecturer);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SubjectClass)) {
            return false;
        }
        SubjectClass subjectClass = (SubjectClass) o;
        return Objects.equals(subjectClassId, subjectClass.subjectClassId) && Objects.equals(subject, subjectClass.subject) && Objects.equals(lecturer, subjectClass.lecturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectClassId, subject, lecturer);
    }

    @Override
    public String toString() {
        return "{" +
            " subjectClassId='" + getSubjectClassId() + "'" +
            ", subject='" + getSubject() + "'" +
            ", lecturer='" + getLecturer() + "'" +
            "}";
    }

}
