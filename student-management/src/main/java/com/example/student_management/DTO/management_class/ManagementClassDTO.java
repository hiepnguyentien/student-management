package com.example.student_management.dto.management_class;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ManagementClassDTO {
    Long id;
    String name;
    Long facultyId;
    Long lecturerId;
}
