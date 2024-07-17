package com.example.student_management.dto.faculty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UpdateFacultyDTO {
    Long facultyId;
    String facultyName;
}
