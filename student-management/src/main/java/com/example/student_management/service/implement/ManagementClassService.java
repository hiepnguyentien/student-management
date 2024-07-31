package com.example.student_management.service.implement;

import com.example.student_management.service.abstracts.IManagementClassService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.management_class.ManagementClassDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.ManagementClassMapper;
import com.example.student_management.repository.ManagementClassRepository;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ManagementClassService implements IManagementClassService {
    ManagementClassRepository managementClassRepository;
    ManagementClassMapper managementClassMapper;
    MessageSource messageSource;

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'LECTURER', 'STUDENT')")
    public ManagementClassDTO findManagementClassById(Long id, Locale locale) {
        return managementClassRepository.findById(id)
                .map(managementClassMapper::toManagementClassDTO)
                .orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND, messageSource, locale));
    }

}
