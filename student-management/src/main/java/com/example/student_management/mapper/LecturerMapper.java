package com.example.student_management.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.model.Lecturer;

@Mapper(componentModel = "spring")
public interface LecturerMapper {
    @Mapping(source = "managementClassId", target = "managementClass.managementClassId")
    @Mapping(target = "roles", ignore = true)
    Lecturer toLecturer(AddLecturerDTO request);

    @Mapping(source = "managementClass.managementClassId", target = "managementClassId")
    LecturerDTO toLecturerDTO(Lecturer lecturer);

    @Mapping(target = "roles", ignore = true)
    void updateLecturer(@MappingTarget Lecturer lecturer, UpdateLecturerDTO request);
}