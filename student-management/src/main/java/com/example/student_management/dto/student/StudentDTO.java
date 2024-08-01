package com.example.student_management.dto.student;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class StudentDTO {
     Long studentId;
     String firstName;
     String lastName;
     String username;
     String email;
     String phoneNumber;
     String address;
     String gender;
     Integer batch;
     LocalDate dateOfBirth;
     Long managementClassId;
     String role;
}
