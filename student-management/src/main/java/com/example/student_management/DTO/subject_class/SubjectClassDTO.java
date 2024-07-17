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
    Long subjectClassId;
    String name;
    Long lecturerId;
    Long subjectId;
}
