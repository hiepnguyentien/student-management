package com.example.student_management.service.abstracts;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    StudentDTO addNewStudent(AddStudentDTO student);

    List<StudentDTO> findStudentByName(String name);

    StudentDTO findStudentById(Long id);

    Optional<Student> findStudentByIdForService(Long id);

    List<StudentDTO> findStudentByManagementClassName(String name);

    List<StudentDTO> findStudentByManagementClassId(Long id);

    StudentDTO updateStudent(Long studentId, UpdateStudentDTO student);

    void deleteStudent(Long id);

}
