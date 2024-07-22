package com.example.student_management.mapper;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "managementClassId", target = "managementClass.managementClassId")
    Student toStudent(AddStudentDTO request);

    @Mapping(source = "managementClass.managementClassId", target = "managementClassId")
    StudentDTO toStudentDTO(Student student);

    void updateStudent(@MappingTarget Student student, UpdateStudentDTO request);
}
