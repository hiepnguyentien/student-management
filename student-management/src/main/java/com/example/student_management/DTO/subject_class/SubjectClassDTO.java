package com.example.student_management.dto.subject_class;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class SubjectClassDTO {
    Long id;
    String name;
    Long lecturerId;
    Long subjectId;
}
