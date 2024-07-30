package com.example.student_management.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.example.student_management.validator.DobConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
@Entity(name = "student")
public class Student {
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
    Integer batch;

    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "username", nullable = false, unique = true)
    String username;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "address")
    String address;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    String email;
    @Column(name = "phone_number", nullable = false, unique = true)
    @Size(max = 10, min = 10, message = "INVALID_PHONE_NUMBER")
    String phoneNumber;
    @Column(name = "gender")
    String gender;
    @Column(name = "date_of_birth", nullable = false)
    @DobConstraint(min = 17, message = "INVALID_DATE_OF_BIRTH")
    LocalDate dateOfBirth;
    Set<String> roles;

    public int getBatch() {
        if (enrollDate != null) {
            return enrollDate.getYear() - 1965;
        } else {
            return 0;
        }
    }
}
