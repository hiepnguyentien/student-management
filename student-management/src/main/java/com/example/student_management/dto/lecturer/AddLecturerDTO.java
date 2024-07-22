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
public class AddLecturerDTO {
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
    LocalDate dateOfBirth;
    Long facultyId;
    Long managementClassId;
}
