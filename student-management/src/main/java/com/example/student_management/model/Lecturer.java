package com.example.student_management.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "lecturer")
public class Lecturer{
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
    String phoneNumber;

    @Column(name = "gender")
    String gender;

    @Column(name = "date_of_birth", nullable = false)
    LocalDate dateOfBirth;
}
