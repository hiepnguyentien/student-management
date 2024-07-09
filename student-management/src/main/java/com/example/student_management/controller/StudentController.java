package com.example.student_management.controller;

import com.example.student_management.DTO.StudentDTO;
import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("find-all")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
