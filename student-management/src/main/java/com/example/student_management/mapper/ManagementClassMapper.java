package com.example.student_management.mapper;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.dto.management_class.UpdateManagementClassDTO;
import com.example.student_management.model.ManagementClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ManagementClassMapper {
    @Mapping(source = "lecturerId", target = "lecturer.lecturerId")
    @Mapping(source = "facultyId", target = "faculty.facultyId")
    ManagementClass toManagementClass(ManagementClassDTO managementClassDTO);

    @Mapping(source = "lecturer.lecturerId", target = "lecturerId")
    @Mapping(source = "faculty.facultyId", target = "facultyId")
    ManagementClassDTO toManagementClassDTO(ManagementClass managementClass);

    void updateManagementClassDTO(@MappingTarget ManagementClass managementClass, UpdateManagementClassDTO request);
}
