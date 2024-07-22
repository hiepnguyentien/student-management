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
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "subject_class")
@Entity
public class SubjectClass {
    @Id
    @SequenceGenerator(name = "subject_class_sequence", sequenceName = "subject_class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_class_sequence")
    @Column(name = "subject_class_id")
    Long subjectClassId;
    @Column(name = "name", nullable = false, unique = true)
    String name;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    Lecturer lecturer;
    @OneToMany(mappedBy = "subjectClass")
    List<Score> scores;
}
