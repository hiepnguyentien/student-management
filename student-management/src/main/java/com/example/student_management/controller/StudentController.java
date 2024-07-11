package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/find-all")
    public List<StudentDTO> findAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("id/{id}")
    public StudentDTO findById(@PathVariable Long id){
        StudentDTO student = studentService.findStudentById(id);
        return student;
    }

    @GetMapping("name/{name}")
    public List<StudentDTO> findStudentByName(@PathVariable String name){
        return studentService.findStudentByName(name);
    }

    @GetMapping("class-name/{name}")
    public List<StudentDTO> findStudentByManagementClassName(@PathVariable String name){
        return studentService.findStudentByManagementClassName(name);
    }

    @GetMapping("class-id/{id}")
    public List<StudentDTO> findStudentByManagementClassId(@PathVariable Long id){
        return studentService.findStudentByManagementClassId(id);
    }

    @GetMapping("test/{id}")
    public Student findStudentById2(@PathVariable Long id){
        return studentService.findStudentById2(id);
    }

    @PostMapping
    public ApiResponse<StudentDTO> addNewStudent(@RequestBody @Valid AddStudentDTO student){
        ApiResponse<StudentDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(studentService.addNewStudent(student));
        return apiResponse;
    }
}
