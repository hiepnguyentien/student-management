package com.example.student_management.service.abstracts;

import java.util.Optional;
import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.model.ManagementClass;

public interface IManagementClassService {
    public Optional<ManagementClass> findManagementClassByIdForService(Long id); 
    
    public ManagementClass findManagementClassById(Long id); 

}