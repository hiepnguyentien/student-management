package com.example.student_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class Person {
    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

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
