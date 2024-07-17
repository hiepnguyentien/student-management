package com.example.student_management.service.implement;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.abstracts.IStudentService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO addNewStudent(AddStudentDTO addStudentDTO) {
        if (studentRepository.existsByEmail(addStudentDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (studentRepository.existsByPhoneNumber(addStudentDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }

        System.out.println("------------------addStudentDTO: " + addStudentDTO + "----------------------");
        Student student = studentMapper.toStudent(addStudentDTO);

        System.out.println("------------------student: " + student + "----------------------");
        studentRepository.save(student);

        return studentMapper.toStudentDTO(student);
    }

    @Override
    public List<StudentDTO> findStudentByName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getFirstName().contains(name) || student.getLastName().contains(name))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        return studentMapper.toStudentDTO(studentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND)));
    }

    @Override
    public List<StudentDTO> findStudentByManagementClassName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getName().contains(name))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentByManagementClassId(Long id) {
        boolean exists = studentRepository.findAll().stream()
                .anyMatch(student -> student.getManagementClass().getManagementClassId().equals(id));

        if (!exists) {
            throw new AppException(ErrorCode.MANAGEMENT_CLASS_NOT_FOUND);
        }

        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getManagementClassId().equals(id))
                .map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long studentId, UpdateStudentDTO input) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND));
        studentMapper.updateStudent(student, input);

        studentRepository.save(student);

        return studentMapper.toStudentDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOT_FOUND));
        studentRepository.delete(student);
    }

    @Override
    public Optional<Student> findStudentByIdForService(Long id) {
        return studentRepository.findById(id);
    }
}
