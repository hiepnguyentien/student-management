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
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "subject")
@Entity
public class Subject {
    @Id
    @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    @Column(name = "subject_id")
    Long subjectId;
    @Column(nullable = false)
    String name;
    String description;
    @Column(nullable = false)
    Integer credit;
    @ManyToMany(mappedBy = "subjects")
    Set<Faculty> faculties = new HashSet<>();
    @OneToMany(mappedBy = "subject")
    List<SubjectClass> subjectClasses;
}
