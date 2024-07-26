package com.example.student_management.service.implement;

import com.example.student_management.dto.lecturer.AddLecturerDTO;
import com.example.student_management.dto.lecturer.LecturerDTO;
import com.example.student_management.dto.lecturer.UpdateLecturerDTO;
import com.example.student_management.enums.Role;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.LecturerMapper;
import com.example.student_management.model.Lecturer;
import com.example.student_management.model.Student;
import com.example.student_management.repository.LecturerRepository;
import com.example.student_management.service.abstracts.ILecturerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LecturerService implements ILecturerService {
    LecturerRepository lecturerRepository;
    LecturerMapper lecturerMapper;
    MessageSource messageSource;
    PasswordEncoder passwordEncoder;

    @Override
    public List<LecturerDTO> findAll() {
        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerById(Long id, Locale locale) {
        return lecturerMapper.toLecturerDTO(lecturerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND, messageSource, locale)));
    }

    @Override
    public List<LecturerDTO> findLecturerByName(String name) {
        return lecturerRepository.findAll()
                .stream()
                .filter(l -> l.getFirstName().contains(name) || l.getLastName().contains(name))
                .map(lecturerMapper::toLecturerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LecturerDTO> findLecturerByFacultyId(Long id, Locale locale) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getFacultyId().equals(id));

        if (!isExist) {
            throw new AppException(ErrorCode.FACULTY_NOT_FOUND, messageSource, locale);
        }

        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .filter(lecturer -> lecturer.getFacultyId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDTO findLecturerByManagementClassId(Long id, Locale locale) {
        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(lecturer -> lecturer.getManagementClass().getManagementClassId().equals(id));

        if (!isExist) {
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND, messageSource, locale);
        }

        return lecturerRepository.findAll().stream()
                .map(lecturerMapper::toLecturerDTO)
                .filter(lecturer -> lecturer.getManagementClassId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND, messageSource, locale));
    }

    @Override
    @Transactional
    public LecturerDTO updateLecturer(Long id, UpdateLecturerDTO updateLecturerDTO, Locale locale) {
        Lecturer lecturer = lecturerRepository.findById(updateLecturerDTO.id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND, messageSource, locale));

        boolean isExist = lecturerRepository.findAll().stream()
                .anyMatch(
                        l -> l.getManagementClass().getManagementClassId().equals(updateLecturerDTO.managementClassId));

        if (!lecturer.getManagementClass().getManagementClassId().equals(updateLecturerDTO.managementClassId)
                || !lecturer.getLecturerId().equals(id)
                        && isExist) {
            throw new AppException(ErrorCode.ANOTHER_LECTURER_IN_MANAGEMENT_CLASS, messageSource, locale);
        }

        lecturerMapper.updateLecturer(lecturer, updateLecturerDTO);

        lecturerRepository.save(lecturer);

        return lecturerMapper.toLecturerDTO(lecturer);
    }

    @Override
    @Transactional
    public LecturerDTO addLecturer(AddLecturerDTO addLecturerDTO, Locale locale) {
        if (lecturerRepository.existsByEmail(addLecturerDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED, messageSource, locale);
        }
        if (lecturerRepository.existsByPhoneNumber(addLecturerDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS, messageSource, locale);
        }
        Lecturer lecturer = lecturerMapper.toLecturer(addLecturerDTO);
        lecturer.setPassword(passwordEncoder.encode(addLecturerDTO.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.LECTURER.name());

        lecturer.setRoles(roles);

        lecturerRepository.save(lecturer);
        return lecturerMapper.toLecturerDTO(lecturer);
    }

    @Override
    @Transactional
    public void deleteLecturer(Long id, Locale locale) {
        Lecturer lecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LECTURER_NOT_FOUND, messageSource, locale));
        lecturerRepository.delete(lecturer);
    }
}
