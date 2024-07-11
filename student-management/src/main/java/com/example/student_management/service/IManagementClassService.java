package com.example.student_management.service;

import java.util.Optional;
import com.example.student_management.dto.managementClass.ManagementClassDTO;
import com.example.student_management.model.ManagementClass;

public interface IManagementClassService {
    public Optional<ManagementClass> findManagementClassByIdForService(Long id); 
    
    public Optional<ManagementClassDTO> findManagementClassById(Long id); 

}