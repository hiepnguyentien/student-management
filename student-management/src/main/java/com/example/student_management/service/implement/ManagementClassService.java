package com.example.student_management.service;

import java.util.Optional;

import com.example.student_management.service.abstracts.IManagementClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.management_class.ManagementClassDTO;
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

    private ManagementClassDTO convertToDTO(ManagementClass managementClass) {
        return new ManagementClassDTO(
                managementClass.getManagementClassId(),
                managementClass.getName(),
                managementClass.getFaculty().getFacultyId(),
                managementClass.getLecturer().getLecturerId()
        );
    }

    @Override
    public Optional<ManagementClassDTO> findManagementClassById(Long id) {
        Optional<ManagementClass> management
                = managementClassRepository.findById(id);
        if (management.isPresent()) {
            return Optional.of(convertToDTO(management.get()));
        }
        return Optional.empty();
    }
    
}
