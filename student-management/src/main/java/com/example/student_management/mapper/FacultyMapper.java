package com.example.student_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.student_management.dto.faculty.AddNewFacultyDTO;
import com.example.student_management.dto.faculty.FacultyDTO;
import com.example.student_management.dto.faculty.UpdateFacultyDTO;
import com.example.student_management.model.Faculty;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    Faculty toFaculty(AddNewFacultyDTO request);

    FacultyDTO toFacultyDTO(Faculty faculty);

    void updateFaculty(@MappingTarget Faculty faculty, UpdateFacultyDTO request);
}
