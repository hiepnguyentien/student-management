package com.example.student_management.service.implement;

import java.util.Optional;

import com.example.student_management.service.abstracts.IManagementClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.repository.ManagementClassRepository;

@Service
public class ManagementClassService implements IManagementClassService {

    private final ManagementClassRepository managementClassRepository;

    @Autowired
    public ManagementClassService(ManagementClassRepository managementClassRepository) {
        this.managementClassRepository = managementClassRepository;
    }

    @Override
    public Optional<ManagementClass> findManagementClassByIdForService(Long id) {
        return managementClassRepository.findById(id);
    }

    @Override
    public ManagementClass findManagementClassById(Long id) {
        return managementClassRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND));
    }
    
}
