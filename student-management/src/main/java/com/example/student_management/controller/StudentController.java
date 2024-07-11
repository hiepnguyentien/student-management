package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
        return studentService.findStudentById(id);

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

    //apiResponse https://www.youtube.com/watch?v=a9wMrj-JHV4&t=109s 9:05
    @PostMapping
    public ApiResponse<AddStudentDTO> addNewStudent(@RequestBody @Valid AddStudentDTO student){
        ApiResponse<AddStudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.addNewStudent(student));

        return apiResponse;
    }

    @PutMapping
    public ApiResponse<UpdateStudentDTO> updateStudent(@RequestBody @Valid UpdateStudentDTO student){
        ApiResponse<UpdateStudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.updateStudent(student));

        return apiResponse;
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

//    @PostMapping
//    public AddStudentDTO addNewStudent(@RequestBody @Valid AddStudentDTO student){
//        studentService.addNewStudent(student);
//        return student;
//    }
}
