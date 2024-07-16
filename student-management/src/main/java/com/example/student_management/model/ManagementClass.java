package com.example.student_management.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "management_class")
@Entity(name = "management_class")
public class ManagementClass {
    @Id
    @SequenceGenerator(name = "management_class_sequence", sequenceName = "management_class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "management_class_sequence")
    @Column(name = "management_class_id")
    Long managementClassId;
    @Column(nullable = false, unique = true)
    String name;
    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    Faculty faculty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    Lecturer lecturer;
    @OneToMany(mappedBy = "managementClass", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Student> students;
}
