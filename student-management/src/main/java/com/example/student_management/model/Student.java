package com.example.student_management.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
@Entity(name = "student")
public class Student extends Person {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "student_id")
    Long studentId;
    LocalDate enrollDate;
    @ManyToOne
    @JoinColumn(name = "management_class_id", nullable = false)
    ManagementClass managementClass;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Score> scores;

    public Integer getBatch() {
        return getEnrollDate().getYear() - 1965;
    }
}
