package com.example.student_management.dto.lecturer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class LecturerDTO {
    Long lecturerId;
    String firstName;
    String lastName;
    String userName;
    String password;
    String email;
    String phoneNumber;
    String address;
    String gender;
    LocalDate dateOfBirth;
    Long facultyId;
    Long managementClassId;
}
