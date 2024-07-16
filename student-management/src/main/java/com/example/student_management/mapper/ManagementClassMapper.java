package com.example.student_management.mapper;

import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import org.mapstruct.Mapper;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.repository.ManagementClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ManagementClassMapper {

    @Autowired
    private ManagementClassRepository managementClassRepository;

    public ManagementClass toManagementClass(Long id) {
        return managementClassRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND));
    }
}
