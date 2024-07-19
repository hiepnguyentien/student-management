package com.example.student_management.dto.lecturer;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UpdateLecturerDTO {
    Long id;
    @NotNull(message = "NAME_BLANK")
    String firstName;
    @NotNull(message = "NAME_BLANK")
    String lastName;
    @Email(message = "INVALID_EMAIL")
    @UniqueElements(message = "EMAIL_EXISTED")
    String email;
    @Size(min = 10, max = 10, message = "INVALID_PHONE_NUMBER")
    @UniqueElements(message = "PHONE_NUMBER_ALREADY_EXIST")
    String phoneNumber;
    String address;
    String gender;
    @NotNull(message = "DATE_OF_BIRTH_BLANK")
    LocalDate dateOfBirth;
    @NotNull(message = "FACULTY_BLANK")
    Long facultyId;
    Long managementClassId;
}
