package com.example.student_management.dto.lecturer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class LecturerDTO {
    Long lecturerId;
    String firstName;
    String lastName;
    String username;
    String email;
    String phoneNumber;
    String address;
    String gender;
    LocalDate dateOfBirth;
    Long facultyId;
    Long managementClassId;
    Set<String> roles;
}
