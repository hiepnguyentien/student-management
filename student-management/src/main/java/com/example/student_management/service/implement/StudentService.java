package com.example.student_management.service.implement;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.enums.Roles;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.model.Role;
import com.example.student_management.model.Student;
import com.example.student_management.repository.RoleRepository;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.abstracts.IStudentService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;
    MessageSource messageSource;
    RoleRepository roleRepository;

    @Override
    @PreAuthorize("hasAuthority('FIND_ALL_STUDENT')")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('ADD_STUDENT')")
//    @PreAuthorize("hasRole('ADMIN')")
    public StudentDTO addNewStudent(AddStudentDTO addStudentDTO, Locale locale) {
        if (studentRepository.existsByEmail(addStudentDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED, messageSource, locale);
        }
        if (studentRepository.existsByPhoneNumber(addStudentDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS, messageSource, locale);
        }

        boolean isManagementClassExist = studentRepository
                .findAll().stream().anyMatch(m -> m.getManagementClass().getManagementClassId().equals(addStudentDTO.getManagementClassId()));
        if(!isManagementClassExist) {
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND, messageSource, locale);
        }

        Student student = studentMapper.toStudent(addStudentDTO);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        student.setPassword(passwordEncoder.encode(addStudentDTO.getPassword()));

        Role studentRole = roleRepository.findByName(Roles.STUDENT.name());
        student.setRole(studentRole);

        studentRepository.save(student);
        return studentMapper.toStudentDTO(student);
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_STUDENT_BY_NAME')")
//    @PreAuthorize("hasAnyRole('ADMIN', 'LECTURER')")
    public List<StudentDTO> findStudentByName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getFirstName().contains(name) || student.getLastName().contains(name))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_STUDENT_BY_ID')")
//    @PreAuthorize("hasRole('LECTURER')")
    public StudentDTO findStudentById(Long id, Locale locale) {
        return studentRepository.findById(id)
                .map(studentMapper::toStudentDTO)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale));
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_STUDENT_BY_MANAGEMENT_CLASS_NAME')")
//    @PreAuthorize("hasRole('LECTURER')")
    public List<StudentDTO> findStudentByManagementClassName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getName().contains(name))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('FIND_STUDENT_BY_MANAGEMENT_CLASS_ID')")
//    @PreAuthorize("hasRole('LECTURER')")
    public List<StudentDTO> findStudentByManagementClassId(Long id, Locale locale) {
        boolean exists = studentRepository.findAll().stream()
                .anyMatch(student -> student.getManagementClass().getManagementClassId().equals(id));

        if (!exists) {
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND, messageSource, locale);
        }

        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getManagementClassId().equals(id))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PostAuthorize("returnObject.username == authentication.name")
    public StudentDTO getMyInfo(Locale locale){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Student student = studentRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale));

        return studentMapper.toStudentDTO(student);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('UPDATE_STUDENT')")
//    @PreAuthorize("hasRole('ADMIN')")
    public StudentDTO updateStudent(Long studentId, UpdateStudentDTO input, Locale locale) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale));
        studentMapper.updateStudent(student, input);

        studentRepository.save(student);

        return studentMapper.toStudentDTO(student);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('DELETE_STUDENT')")
//    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(Long id, Locale locale) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND, messageSource, locale));
        studentRepository.delete(student);
    }
}
