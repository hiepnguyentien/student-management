package com.example.student_management.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "lecturer")
public class Lecturer extends Person {
    @Id
    @SequenceGenerator(name = "lecturer_sequence", sequenceName = "lecturer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecturer_sequence")
    @Column(name = "lecturer_id")
    Long lecturerId;

    @Column(name = "faculty_id", nullable = false)
    Long facultyId;

    @OneToOne(mappedBy = "lecturer")
    ManagementClass managementClass;

    @OneToMany(mappedBy = "lecturer")
    List<SubjectClass> subjectclasses;
}
