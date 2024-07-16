package com.example.student_management.dto.subject;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UpdateSubjectDTO {
    Long id;
    String name;
    String description;
    Integer credit;
}
