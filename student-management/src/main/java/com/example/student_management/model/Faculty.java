package com.example.student_management.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "faculty")
@Entity
public class Faculty {
    @Id
    @SequenceGenerator(name = "faculty_sequence", sequenceName = "faculty_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_sequence")    
    @Column(name = "faculty_id")
    Long facultyId;
    @Column(name = "faculty_name", nullable = false)
    String facultyName;
    @ManyToMany
    @JoinTable(
        name = "subject_faculty",
        joinColumns = @JoinColumn(name = "faculty_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    List<Subject> subjects;
    @OneToMany(mappedBy = "faculty")
    List<ManagementClass> managementClasses;
}
