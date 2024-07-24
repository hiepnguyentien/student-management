package com.example.student_management.service.abstracts;

import java.util.Locale;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.model.ManagementClass;

public interface IManagementClassService {
    public ManagementClassDTO findManagementClassById(Long id, Locale locale);

}