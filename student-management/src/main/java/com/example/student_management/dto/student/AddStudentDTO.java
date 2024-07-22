package com.example.student_management.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UniqueElements;

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
    @Email(message = "INVALID_EMAIL")
    String email;
    @Size(min = 10, max = 10, message = "INVALID_PHONE_NUMBER")
    String phoneNumber;
    String address;
    String gender;
    @NotNull(message = "DATE_OF_BIRTH_BLANK")
    LocalDate dateOfBirth;
    LocalDate enrollDate;
    Integer batch;
    Long managementClassId;
}
