package com.example.student_management.service;

import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;

import java.util.List;

public interface IStudentService {
    AddStudentDTO addNewStudent(AddStudentDTO student);

    List<StudentDTO> findStudentByName(String name);

    StudentDTO findStudentById(Long id);

    List<StudentDTO> findStudentByManagementClassName(String name);

    List<StudentDTO> findStudentByManagementClassId(Long id);

    UpdateStudentDTO updateStudent(UpdateStudentDTO student);

    void deleteStudent(Long id);

}
