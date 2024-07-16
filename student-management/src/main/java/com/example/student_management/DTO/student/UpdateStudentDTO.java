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
public class UpdateStudentDTO {
    Long id;
    @NotNull(message = "Tên không được để trống")
    String firstName;
    @NotNull(message = "Tên không được để trống")
    String lastName;
    @Email(message = "email không hợp lệ")
    String email;
    @Size(min = 10, message = "INVALID_PHONE_NUMBER")
    @Size(max = 10, message = "INVALID_PHONE_NUMBER")
    String phoneNumber;
    String address;
    String gender;
    LocalDate dateOfBirth;
    Long managementClassId;
}
