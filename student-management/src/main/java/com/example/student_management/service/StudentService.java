package com.example.student_management.service;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.ManagementClass;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final ManagementClassService managementClassService;

    @Autowired
    public StudentService(StudentRepository studentRepository, ManagementClassService managementClassService) {
        this.studentRepository = studentRepository;
        this.managementClassService = managementClassService;
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getAddress(),
                student.getGender(),
                student.getDateOfBirth(),
                student.getManagementClass().getName());
    }

    public AddStudentDTO addNewStudent(AddStudentDTO addStudentDTO) {
        if (studentRepository.existsByEmail(addStudentDTO.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        if (studentRepository.existsByPhoneNumber(addStudentDTO.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }
        Student student = convertToEntity(addStudentDTO);
        studentRepository.save(student);
        return addStudentDTO;
    }

    private Student convertToEntity(AddStudentDTO addStudentDTO) {
        Student student = new Student();
        student.setFirstName(addStudentDTO.getFirstName());
        student.setLastName(addStudentDTO.getLastName());
        student.setEmail(addStudentDTO.getEmail());
        student.setPhoneNumber(addStudentDTO.getPhoneNumber());
        student.setAddress(addStudentDTO.getAddress());
        student.setGender(addStudentDTO.getGender());
        student.setDateOfBirth(addStudentDTO.getDateOfBirth());

        ManagementClass managementClass = managementClassService
                .findManagementClassByIdForService(addStudentDTO.getManagementClassId()).orElse(null);
        student.setManagementClass(managementClass);
        return student;
    }

    @Override
    public List<StudentDTO> findStudentByName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getFirstName().contains(name) || student.getLastName().contains(name))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOTFOUND));
    }


    //TEST
    @Override
    public Student findStudentById2(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Sinh viên này không tồn tại"));
    }

    @Override
    public List<StudentDTO> findStudentByManagementClassName(String name) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getName().contains(name))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentByManagementClassId(Long id) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getManagementClass().getManagementClassId().equals(id))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateStudentDTO updateStudent(UpdateStudentDTO input) {
        Student student = studentRepository.findById(input.getId())
        .orElseThrow(() -> new AppException(ErrorCode.STUDENT_NOTFOUND));
 
        student.setFirstName(input.getFirstName());
        student.setLastName(input.getLastName());
        student.setEmail(input.getEmail());
        student.setPhoneNumber(input.getPhoneNumber());
        student.setAddress(input.getAddress());
        student.setGender(input.getGender());
        student.setDateOfBirth(input.getDateOfBirth());

        ManagementClass managementClass = managementClassService
        .findManagementClassByIdForService(input.getManagementClassId())
        .orElseThrow(() -> new AppException(ErrorCode.MANAGEMENT_CLASS_NOTFOUND));
        
        student.setManagementClass(managementClass);
        studentRepository.save(student);
        return input;
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new AppException(ErrorCode.STUDENT_NOTFOUND);
        }
        studentRepository.deleteById(id);
    }
}
