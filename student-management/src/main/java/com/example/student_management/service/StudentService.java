package com.example.student_management.service;

import com.example.student_management.DTO.StudentDTO;
import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = convertToDTO(student);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }
    
    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setGender(student.getGender());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setManagementClass(student.getManagementClass());
        return studentDTO;
    }

    public void addNewStudent(Student student) {
        Optional<StudentDTO> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }
}
