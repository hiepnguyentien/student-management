package com.example.student_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.student_management.dto.subject.AddSubjectDTO;
import com.example.student_management.dto.subject.SubjectDTO;
import com.example.student_management.dto.subject.UpdateSubjectDTO;
import com.example.student_management.model.Subject;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toSubject(AddSubjectDTO request);

    SubjectDTO toSubjectDTO(Subject subject);

    void updateSubject(@MappingTarget Subject subject, UpdateSubjectDTO request);
}
