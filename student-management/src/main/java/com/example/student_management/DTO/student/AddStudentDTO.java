package com.example.student_management.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Objects;

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
    @Email(message = "email không hợp lệ")
    String email;
    @Size(min = 10, max = 10, message = "PHONE_NUMBER_INVALID")
    String phoneNumber;
    String address;
    String gender;
    LocalDate dateOfBirth;
    Long managementClassId;
}
