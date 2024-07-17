package com.example.student_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.student_management.dto.subject_class.AddSubjectClassDTO;
import com.example.student_management.dto.subject_class.SubjectClassDTO;
import com.example.student_management.dto.subject_class.UpdateSubjectClassDTO;
import com.example.student_management.model.SubjectClass;

@Mapper(componentModel = "spring")
public interface SubjectClassMapper {
    @Mapping(source = "lecturerId", target = "lecturer.lecturerId")
    @Mapping(source = "subjectId", target = "subject.subjectId")
    SubjectClass toSubjectClass(AddSubjectClassDTO request);

    @Mapping(source = "lecturer.lecturerId", target = "lecturerId")
    @Mapping(source = "subject.subjectId", target = "subjectId")
    SubjectClassDTO toSubjectClassDTO(SubjectClass subjectClass);
    
    void updateSubjectClass(@MappingTarget SubjectClass subjectClass, UpdateSubjectClassDTO request);
}
