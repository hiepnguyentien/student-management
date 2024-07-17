package com.example.student_management.service.implement;

import java.util.Optional;

import com.example.student_management.service.abstracts.IManagementClassService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.repository.ManagementClassRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ManagementClassService implements IManagementClassService {
    ManagementClassRepository managementClassRepository;

    @Override
    public ManagementClass findManagementClassById(Long id) {
        return managementClassRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND));
    }
    
}
