package com.example.student_management.dto.management_class;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AddManagementClassDTO {
    @NotNull(message = "CLASS_NAME_BLANK")
    String name;
    @NotNull(message = "FACULTY_BLANK")
    Long facultyId;
    @NotNull(message = "LECTURER_BLANK")
    Long lecturerId;
}
