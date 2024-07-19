package com.example.student_management.dto.management_class;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ManagementClassDTO {
    Long managementClassId;
    String name;
    Long facultyId;
    Long lecturerId;
}
