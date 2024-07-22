package com.example.student_management.dto.subject;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AddSubjectDTO {
    String name;
    String description;
    Integer credit;
}
