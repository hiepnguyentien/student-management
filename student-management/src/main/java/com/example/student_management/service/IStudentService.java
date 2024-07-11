package com.example.student_management.service;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    AddStudentDTO addNewStudent(AddStudentDTO student);

    List<StudentDTO> findStudentByName(String name);

    StudentDTO findStudentById(Long id);

    List<StudentDTO> findStudentByManagementClassName(String name);

    List<StudentDTO> findStudentByManagementClassId(Long id);

    UpdateStudentDTO updateStudent(UpdateStudentDTO student);

    void deleteStudent(Long id);

    //TEST
    Student findStudentById2(Long id);
}
