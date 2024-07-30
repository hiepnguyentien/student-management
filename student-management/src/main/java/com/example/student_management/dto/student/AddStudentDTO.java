package com.example.student_management.dto.student;

import com.example.student_management.validator.DobConstraint;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AddStudentDTO {
    @NotNull(message = "NAME_BLANK")
    String firstName;
    @NotNull(message = "NAME_BLANK")
    String lastName;
    @NotNull(message = "USERNAME_BLANK")
    String username;
    @NotNull(message = "PASSWORD_BLANK")
    String password;
    @Email(message = "INVALID_EMAIL")
    String email;
    @Size(min = 10, max = 10, message = "INVALID_PHONE_NUMBER")
    String phoneNumber;
    String address;
    String gender;
    @NotNull(message = "DATE_OF_BIRTH_BLANK")
    @DobConstraint(min = 18, message = "INVALID_DATE_OF_BIRTH")
    LocalDate dateOfBirth;
    LocalDate enrollDate;
    Long managementClassId;
}
