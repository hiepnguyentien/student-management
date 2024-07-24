package com.example.student_management.service.abstracts;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;

import java.util.List;
import java.util.Locale;

import org.springframework.cglib.core.Local;

public interface IStudentService {
    List<StudentDTO> findAll();

    List<StudentDTO> findStudentByName(String name);
    
    StudentDTO findStudentById(Long id, Locale locale);
    
    List<StudentDTO> findStudentByManagementClassName(String name);
    
    List<StudentDTO> findStudentByManagementClassId(Long id, Locale locale);
    
    StudentDTO addNewStudent(AddStudentDTO student, Locale locale);

    StudentDTO updateStudent(Long studentId, UpdateStudentDTO student, Locale locale);

    void deleteStudent(Long id, Locale locale);

}
