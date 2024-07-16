package com.example.student_management.dto.lecturer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class LecturerDTO {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String gender;
    LocalDate dateOfBirth;
    Long facultyId;
    Long managementClassId;
}
