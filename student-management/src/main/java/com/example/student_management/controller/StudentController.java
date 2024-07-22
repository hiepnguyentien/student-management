package com.example.student_management.controller;

import com.example.student_management.dto.ApiResponse;
import com.example.student_management.dto.student.AddStudentDTO;
import com.example.student_management.dto.student.StudentDTO;
import com.example.student_management.dto.student.UpdateStudentDTO;
import com.example.student_management.service.implement.StudentService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;

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
    public ApiResponse<List<StudentDTO>> findStudentByManagementClassId(@PathVariable @Valid Long id){
        ApiResponse<List<StudentDTO>> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.findStudentByManagementClassId(id));

        return apiResponse;
    }

    @PostMapping
    public ApiResponse<StudentDTO> addNewStudent(@RequestBody @Valid AddStudentDTO student){
        ApiResponse<StudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.addNewStudent(student));

        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentDTO> updateStudent(@PathVariable @Valid Long id, @RequestBody @Valid UpdateStudentDTO student){
        ApiResponse<StudentDTO> apiResponse = new ApiResponse<>();

        apiResponse.setResult(studentService.updateStudent(id, student));

        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
